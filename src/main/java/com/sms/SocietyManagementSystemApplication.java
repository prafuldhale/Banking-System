package com.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocietyManagementSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(SocietyManagementSystemApplication.class, args);	
		
//		UsersService bean = run.getBean(UsersService.class);
//		
//		UserDTO userDTO = new UserDTO();
//		userDTO.setPassword("password");
//		userDTO.setUsername("username");
//		userDTO.setPosition("Member");
//		
//		bean.insertUserDetails(userDTO);
	}
}
 