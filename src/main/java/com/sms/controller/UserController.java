package com.sms.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.apache.catalina.valves.JsonAccessLogValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sms.dto.UserDTO;
import com.sms.entity.Users;
import com.sms.exception.UserNotFoundException;
import com.sms.service.UsersService;

import ch.qos.logback.core.model.Model;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	UsersService usersService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
//	@Autowired
//	BCryptPasswordEncoder bcruypt;
	
	@GetMapping("/test")
	public HttpStatus test() {
		System.out.println("Api hitted");
		return HttpStatus.ACCEPTED;
	}
	
	@PostMapping("/adduser")
	public HttpStatus addUser(@RequestBody UserDTO userDTO) {
		if(userDTO == null) return HttpStatus.BAD_REQUEST;
		
		System.out.println(userDTO);
		usersService.insertUserDetails(userDTO);
		return HttpStatus.ACCEPTED;
	}
	public Users getUserByUsername(String username) throws UserNotFoundException {
		Users userDTO = usersService.getUserbyUsername(username);
		if(userDTO == null) {
			throw new UserNotFoundException("Username name not Matched");
		}		
		return userDTO;
	}
	@PostMapping(value = "/login", consumes="application/json")
	public UserDTO loginStatus(@RequestBody UserDTO userDTO) throws UserNotFoundException {
		Users users = getUserByUsername(userDTO.getUsername());
		UserDTO user = new UserDTO();
		user.setId(users.getId());
		user.setUsername(users.getUsername());
		user.setPassword(users.getPassword());
		user.setPosition(users.getPosition().name());
		
		if(passwordEncoder.matches(userDTO.getPassword(),getUserByUsername(userDTO.getUsername()).getPassword())) {
			return user;
		}
		return null;
	}
	
	
	
//	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
	public static String UPLOAD_DIRECTORY = "C:/Angular/Society-Management-System/Society-Management-System/src/assets/uploads";

    @GetMapping("/uploadimage") public String displayUploadForm() {
        return "imageupload/index";
    }

    @PostMapping(value = "/upload") 
    public HttpStatus uploadImage(Model model, @RequestParam("image") MultipartFile file) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        return HttpStatus.OK;
    }
}
