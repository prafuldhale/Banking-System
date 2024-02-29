package com.sms.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Annoucement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int annoucement_id;	
	@Column(name = "title", nullable = false)
	String title;
	@Column(nullable = false)
	String description;
	@Column(nullable = false)
	Date eventDate;
	@Column(nullable = false)
	String time;
	@Column
	String eventManagerName;
		
	public Annoucement(int annoucement_id, String title, String description, Date eventDate, String time) {
		super();
		this.annoucement_id = annoucement_id;
		this.title = title;
		this.description = description;
		this.eventDate = eventDate;
		this.time = time;
	}
	public Annoucement() {
		// TODO Auto-generated constructor stub
	}
	public int getAnnoucement_id() {
		return annoucement_id;
	}
	public void setAnnoucement_id(int annoucement_id) {
		this.annoucement_id = annoucement_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getEventManagerName() {
		return eventManagerName;
	}
	public void setEventManagerName(String eventManagerName) {
		this.eventManagerName = eventManagerName;
	}
	
	
	
}
