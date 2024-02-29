package com.sms.dto;

import java.sql.Date;

public class AnnoucementDTO {

	int annoucement_id;	
	String title;
	String description;
	Date eventDate;
	String time;
	String eventManagerName;
	public AnnoucementDTO(int annoucement_id, String title, String description, Date eventDate, String time) {
		super();
		this.annoucement_id = annoucement_id;
		this.title = title;
		this.description = description;
		this.eventDate = eventDate;
		this.time = time;
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
	@Override
	public String toString() {
		return "AnnoucementDTO [annoucement_id=" + annoucement_id + ", title=" + title + ", description=" + description
				+ ", eventDate=" + eventDate + ", time=" + time + ", eventManagerName=" + eventManagerName + "]";
	}	
	
}
