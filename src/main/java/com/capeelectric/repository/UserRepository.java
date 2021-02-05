package com.capeelectric.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capeelectric.model.User;

/**
 * 
 * @author capeelectricsoftware
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}
