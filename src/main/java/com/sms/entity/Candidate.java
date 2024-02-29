package com.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private Integer votingCount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getVotingCount() {
		return votingCount;
	}
	public void setVotingCount(Integer votingCount) {
		this.votingCount = votingCount;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", votingCount=" + votingCount + "]";
	}
	
	
}
