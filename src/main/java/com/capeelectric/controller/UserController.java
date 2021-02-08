package com.capeelectric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capeelectric.model.User;
import com.capeelectric.service.impl.CustomUserDetailsService;
import com.capeelectric.service.impl.UserDetailsServiceImpl;

/**
 * 
 * @author capeelectricsoftware
 *
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private UserDetailsServiceImpl userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		userService.save(user);
		return "user added successfully";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/fetchUser/{userName}")
	public UserDetails fetchUser(@PathVariable("userName") String userName) {
		return userDetailsService.loadUserByUsername(userName);
	}
}
