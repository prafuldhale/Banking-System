package com.sms.dto;

import java.util.UUID;

import com.sms.entity.Users.positionValue;

public class UserDTO {
	UUID id;
	String username;
	String password;
	String position;
	
	public UserDTO() {
		super();
	}
	public UserDTO(UUID id, String username, String password, String position) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.position = position;
	}
	public String getUsername() {
		return username;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition() {
		return position;
	}
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", position=" + position + "]";
	}
	
	
	

}
