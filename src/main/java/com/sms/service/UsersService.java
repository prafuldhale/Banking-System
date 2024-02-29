package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sms.dto.UserDTO;
import com.sms.entity.Users;
import com.sms.repository.UsersRepo;
@Service
public class UsersService {
	@Autowired
	UsersRepo usersRepo;

	@Autowired
	BCryptPasswordEncoder bEncoder;
//	
	public void insertUserDetails(UserDTO userDTO) {
		Users users = convertDTO(userDTO);
		if(users != null) {
			users.setPassword(bEncoder.encode(users.getPassword()));
			System.out.println("Inside a service Class " + users);
			usersRepo.save(users);
		}
	}
	
	
	public List<Users> getUserDTO() {
		List<Users> list = usersRepo.findAll();
		return list;
	}
	
	public Users getUserbyUsername(String username) {
		Users user = usersRepo.getUserByUsername(username);
		return user;
	}
	
	
	public boolean validateUser(String username, String password) {
		return password.equals(usersRepo.getPasswordByUsername(username));
	}
		
//	public boolean validateUser1(UserDTO userDTO) {
//	
//		Users users = usersRepo.getUserByUsername(userDTO.getUsername());
//		if (bEncoder.matches(userDTO.getPassword(), users.getPassword())) {
//			
//			return true;
//		}
//		
//		return false;
//	}
	
	private Users convertDTO(UserDTO userDTO) {
		Users users = new Users();
		users.setUsername(userDTO.getUsername());
		users.setPassword(userDTO.getPassword());		
		return users;
	}
}
