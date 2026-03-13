package com.example.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public UserDto getUserById(Long id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

		return convertToDto(user);
	}

	private UserDto convertToDto(User user) {
		UserDto dto = new UserDto();
		dto.setUserId(dto.getUserId());
		dto.setName(dto.getName());
		dto.setAddress(dto.getAddress());
		dto.setDbo(dto.getDob());
		dto.setEmail(dto.getEmail());
		dto.setMo_No(dto.getMo_No());
		dto.setGender(dto.getGender());
		dto.setMarried(dto.getMarried());
		dto.setProfession(dto.getProfession());
		return dto;
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = userRepository.findAll();
		return users.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public User updateUser(Long id, User user) {
		
		User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

		existingUser.setEmail(user.getEmail());

		existingUser.setPassword(user.getPassword());

		existingUser.setId(user.getId());

		return userRepository.save(existingUser);

	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);

	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
