package com.berkay.banking_system_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.berkay.banking_system_project.request.EnabledDisabledRequest;
import com.berkay.banking_system_project.request.LoginRequest;
import com.berkay.banking_system_project.request.RegisterRequest;
import com.berkay.banking_system_project.security.JWTTokenUtil;
import com.berkay.banking_system_project.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTTokenUtil tokenUtil;
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(path="user/{id}", method=RequestMethod.PATCH)
	public ResponseEntity<Object> enableDisable(@PathVariable int id, @RequestBody EnabledDisabledRequest enabledDisabledRequest){
		if (this.userService.enableDisableUser(enabledDisabledRequest.isEnabledDisabled(), id)){
			String text = enabledDisabledRequest.isEnabledDisabled() ? "En" : "Dis";
			return new ResponseEntity<Object>(String.format("%sabled User: %d", text, id), HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@RequestMapping(path="register", method=RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest){
		
		
		if (this.userService.registerUser(registerRequest)) return new ResponseEntity<Object>("Registered", HttpStatus.OK);
		
		
		return new ResponseEntity<Object>("Register Failed!", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@RequestMapping(path="authenticate", method = RequestMethod.POST)
	public ResponseEntity<Object> auth(@RequestBody LoginRequest loginRequest){
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));



			final UserDetails userDetails = userDetailService.loadUserByUsername(loginRequest.getUsername());

			final String token = tokenUtil.generateToken(userDetails);
			return new ResponseEntity<Object>(token, HttpStatus.OK);
			
			
		} catch (BadCredentialsException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return new ResponseEntity<Object>("", HttpStatus.BAD_REQUEST);
		} catch (DisabledException e) {
			System.out.println(e);
		}  catch (Exception e) {
			System.out.println(e);
		} 
		return new ResponseEntity<Object>("", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
