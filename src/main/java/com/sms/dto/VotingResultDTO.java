package com.sms.dto;

public class VotingResultDTO {
	private String candidateName;
	private Integer votingCount;
	
	
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public Integer getVotingCount() {
		return votingCount;
	}
	public void setVotingCount(Integer votingCount) {
		this.votingCount = votingCount;
	}
}
