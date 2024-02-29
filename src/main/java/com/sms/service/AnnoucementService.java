package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dto.AnnoucementDTO;
import com.sms.entity.Annoucement;
import com.sms.repository.AnnoucementRepo;

@Service
public class AnnoucementService {
	
	@Autowired
	AnnoucementRepo annoucementRepo;
	
	public void insertAnnoucementEntry(AnnoucementDTO annoucementDTO) {
		Annoucement annoucement = covertDTOToClass(annoucementDTO);
		annoucementRepo.save(annoucement);
	}

	private Annoucement covertDTOToClass(AnnoucementDTO annoucementDTO) {
		// TODO Auto-generated method stuby
		Annoucement annoucement = new Annoucement();
		annoucement.setAnnoucement_id(annoucementDTO.getAnnoucement_id());
		annoucement.setDescription(annoucementDTO.getDescription());
		annoucement.setEventDate(annoucementDTO.getEventDate());
		annoucement.setTime(annoucementDTO.getTime());
		annoucement.setTitle(annoucementDTO.getTitle());
		annoucement.setEventManagerName(annoucementDTO.getEventManagerName());
		return annoucement;
	}
	
	public List<Annoucement> getAllAnnoucements(){
		List<Annoucement> annoucementList = annoucementRepo.findAll();
		return annoucementList;
	}

}
