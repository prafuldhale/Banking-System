package com.sms.service;

import com.sms.entity.Candidate;
import com.sms.repository.VotingResultRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VotingResultService {
	@Autowired
	VotingResultRepo votingResultRepo;

	public List<Candidate> getAllCandidate()	{
		List<Candidate> list = null;
		list = votingResultRepo.findAll();
		return list;
	}
	
	public void updateVoteList(int id) {
		votingResultRepo.updateVotingCount(id);
		
	}

	public void insertCandidate(List<Candidate> candidates) {
		votingResultRepo.saveAll(candidates);		
	}
	
	public Candidate getWinnerFromAllCandidate() {
		List<Candidate> allCandidate = votingResultRepo.findAll();
		Candidate winnerCandidate = new Candidate();
		Map<Candidate, Integer>  candidateMap = new HashMap<Candidate, Integer>();
		winnerCandidate.setVotingCount(0);
		for(Candidate candidate: allCandidate) {
			if(winnerCandidate.getVotingCount() < candidate.getVotingCount()) {
				winnerCandidate = candidate;
				candidateMap.put(winnerCandidate, winnerCandidate.getVotingCount());
			}
		}
		
		
		return winnerCandidate;
	}
	
	
}
