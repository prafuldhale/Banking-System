package com.sms.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	
	public enum positionValue{
		President,
		Secretery,
		Member,
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	UUID id;
	@Column(unique = true)
	String username;
	
	String password;

	String contactNumber;
	String aboutUse;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = true)
	positionValue position;
	
	public Users() {
		
	}
	
	
	public Users(UUID id, String username, String password, String contactNumber, String aboutUse,
			positionValue position) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.contactNumber = contactNumber;
		this.aboutUse = aboutUse;
		this.position = position;
	}


	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
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
	public void setPosition(positionValue position) {
		this.position = position;
	}
	public positionValue getPosition() {
		return position;
	}
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAboutUse() {
		return aboutUse;
	}

	public void setAboutUse(String aboutUse) {
		this.aboutUse = aboutUse;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", contactNumber="
				+ contactNumber + ", aboutUse=" + aboutUse + ", position=" + position + "]";
	}
	
	
		
}
