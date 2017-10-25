package com.ylc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ylc.model.Role;
@Service
public class CitronUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;

	public User loadUserByUsername(final String username) {
		com.ylc.model.User user=new com.ylc.model.User();
		user.setEmailID(username);
		user = userService.findByUserByEmail(user);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
		return buildUserForAuthentication(user, authorities);

	}
	

	private User buildUserForAuthentication(com.ylc.model.User user,
			List<GrantedAuthority> authorities) {	
		boolean enabled=user.getActive() == 1 ? true : false;		
		return new User(user.getCustomerID()+"",user.getPassword(),enabled,true,true, true,authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Role userRole) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));	
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);
		return Result;
	}
}
