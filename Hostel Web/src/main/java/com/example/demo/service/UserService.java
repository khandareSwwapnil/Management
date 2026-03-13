package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

public interface UserService {

	public  User saveUser(User user);

	public UserDto getUserById(Long id);

	public List<UserDto> getAllUser();

	public User updateUser(Long id, User user);
	
	public void deleteUser(Long id);

	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

}
