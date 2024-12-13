package com.ahmet.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmet.controller.ICandidateController;
import com.ahmet.dto.DtoCandidate;
import com.ahmet.dto.DtoCandidateIU;
import com.ahmet.services.ICandidateService;

import jakarta.validation.Valid;

@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4200"})
@RestController
@RequestMapping("/api/candidates")
public class CandidateControllerImpl implements ICandidateController {

	@Autowired
	private ICandidateService candidateService;
	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoCandidate getCandidateById(@PathVariable(required = true) Integer id) {
		return candidateService.getCandidateById(id);
	}
	
	@GetMapping(path = "/list")
	@Override
	public List<DtoCandidate> getAllCandidates() {	
		return candidateService.getAllCandidates();
	}

	@PostMapping(path = "/create")
	@Override
	public DtoCandidate createCandidate(@RequestBody @Valid DtoCandidateIU dtoCandidateIU) {		
		return candidateService.createCandidate(dtoCandidateIU);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoCandidate updateCandidate(@PathVariable(required=true) Integer id, @RequestBody @Valid DtoCandidateIU dtoCandidateIU) {
		return candidateService.updateCandidate(id, dtoCandidateIU);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteCandidate(@PathVariable(required=true) Integer id) {	
		candidateService.deleteCandidate(id);
	}

}
