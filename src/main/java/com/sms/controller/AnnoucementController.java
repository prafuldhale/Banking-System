package com.sms.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.dto.AnnoucementDTO;
import com.sms.entity.Annoucement;
import com.sms.service.AnnoucementService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AnnoucementController {
	@Autowired
	AnnoucementService annoucementService;
	
	@PostMapping("/addAnnoucement")
	public HttpStatus addAnnoucement(@RequestBody AnnoucementDTO annoucementDTO) {
		annoucementService.insertAnnoucementEntry(annoucementDTO);
		
		return HttpStatus.OK;
	}
	
	@GetMapping("/validTaskAfterTodaysDate")
	public List<Annoucement> getAllAnnoucements(){
		
		List<Annoucement> annoucements = new ArrayList<Annoucement>()	;
		List<Annoucement> allAnnoucementsList = annoucementService.getAllAnnoucements();
		Date date = new Date();
		
		for(Annoucement annoucement: allAnnoucementsList) {
			if(annoucement.getEventDate().after(date) ) {
				annoucements.add(annoucement);
			}
		}
		System.out.println(annoucements);
		return annoucements;
	}
//	@GetMapping("/getTodaysAnnouncement")
//	public List<E>

}
