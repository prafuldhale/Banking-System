package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Annoucement;

public interface AnnoucementRepo extends JpaRepository<Annoucement, Integer> {

}
