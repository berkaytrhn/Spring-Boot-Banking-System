package com.berkay.banking_system_project.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private String email;
	private String password;
	
	@Default
	private boolean enabled=true;
	List<SimpleGrantedAuthority> authorities;
	private String authoritiesString;
	
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public void setAuthorities() {
		List<SimpleGrantedAuthority> auths = new ArrayList<>();
		for (String authority : this.authoritiesString.split(",")) {
			auths.add(new SimpleGrantedAuthority(authority));
		}
		this.authorities=auths;
	}
}
