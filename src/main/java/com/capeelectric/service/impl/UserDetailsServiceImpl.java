package com.capeelectric.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capeelectric.model.User;
import com.capeelectric.repository.UserRepository;
import com.capeelectric.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		User userDetails = userRepository.save(user);
		return userDetails;
	}
}
