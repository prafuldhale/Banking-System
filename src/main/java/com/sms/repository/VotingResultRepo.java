package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sms.entity.Candidate;

@Repository
public interface VotingResultRepo extends JpaRepository<Candidate, Integer> {
	
	@Modifying
    @Query("UPDATE Candidate c SET c.votingCount = c.votingCount + 1 WHERE c.id = :candidateId")
    void updateVotingCount(@Param("candidateId") int candidateId);
}
