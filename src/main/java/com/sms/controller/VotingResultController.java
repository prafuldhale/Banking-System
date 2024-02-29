package com.sms.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.dto.VotingResultDTO;
import com.sms.entity.Candidate;
import com.sms.service.VotingResultService;

@RestController
@CrossOrigin("localhost:4200")
public class VotingResultController {
	
	@Autowired
	VotingResultService sResultService;
	
	@GetMapping("getCandidate")
	public List<Candidate> getAllResult(){
		List<Candidate> allCandidate = sResultService.getAllCandidate();
		
		return allCandidate;
	}
	@PostMapping("insertCandidate")
	public HttpStatus insertCandiate(@RequestBody List<VotingResultDTO> votingResultDTOs){
		List<Candidate> candidate = convertDTO(votingResultDTOs);
		sResultService.insertCandidate(candidate);
		return HttpStatus.ACCEPTED;
	}
	private List<Candidate> convertDTO(List<VotingResultDTO> votingResultDTO){
		Candidate  candidate = new Candidate();
		List<Candidate> candidateList = new ArrayList<Candidate>();
		int i = 0;
		for(VotingResultDTO votingResultDTO2: votingResultDTO) {
			candidate.setName(votingResultDTO2.getCandidateName());
			candidate.setVotingCount(0);
			candidateList.add(candidate);
		}
		for (Iterator iterator = candidateList.iterator(); iterator.hasNext();) {
			Candidate candidate2 = (Candidate) iterator.next();
			System.out.println(candidate2);
		}
		return candidateList;
	}
	@PutMapping(value = "vote",  consumes="application/json")
	public HttpStatus updateVoteCount(@RequestBody Integer candidateId) {
		sResultService.updateVoteList(candidateId);
		return HttpStatus.ACCEPTED;
	}
	
	@GetMapping(value = "getWinner")
	public Candidate getWinner() {
		return sResultService.getWinnerFromAllCandidate();
	}
}
