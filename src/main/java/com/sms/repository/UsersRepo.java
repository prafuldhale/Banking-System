package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
	Users getUserByUsername(String username);
	String getPasswordByUsername(String Username);
}
