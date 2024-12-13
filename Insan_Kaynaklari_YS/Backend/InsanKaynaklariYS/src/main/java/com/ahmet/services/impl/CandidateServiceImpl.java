package com.ahmet.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmet.dto.DtoCandidate;
import com.ahmet.dto.DtoCandidateIU;
import com.ahmet.entities.Candidate;
import com.ahmet.repository.CandidateRepository;
import com.ahmet.services.ICandidateService;

@Service
public class CandidateServiceImpl implements ICandidateService {

	@Autowired
	private CandidateRepository candidateRepository;
	
	@Override
	public DtoCandidate getCandidateById(Integer id) {
		Optional<Candidate> candidateOptional = candidateRepository.findById(id);
		if(candidateOptional.isPresent()) {
			DtoCandidate response = new DtoCandidate();
			BeanUtils.copyProperties(candidateOptional.get(), response);
			return response;
		}
		return null;
	}
	
	@Override
	public List<DtoCandidate> getAllCandidates() {
		List<DtoCandidate> response = new ArrayList<>();
		List<Candidate> candidateList = candidateRepository.findAllCandidateAsc();
		for (Candidate candidate : candidateList) {
			DtoCandidate dtoCandidate = new DtoCandidate();
			BeanUtils.copyProperties(candidate, dtoCandidate);
			response.add(dtoCandidate);
		}	
		return response;
	}

	@Override
	public DtoCandidate createCandidate(DtoCandidateIU dtoCandidateIU) {
		DtoCandidate response = new DtoCandidate();
		Candidate candidate = new Candidate();
		BeanUtils.copyProperties(dtoCandidateIU, candidate);
		Candidate dbCandidate = candidateRepository.save(candidate);
		BeanUtils.copyProperties(dbCandidate, response);	
		return response;
	}

	@Override
	public DtoCandidate updateCandidate(Integer id, DtoCandidateIU dtoCandidateIU) {	
		Optional<Candidate> candidateOptional = candidateRepository.findById(id);
		if(candidateOptional.isPresent()) {
			Candidate dbCandidate = candidateOptional.get();
			dbCandidate.setFirstName(dtoCandidateIU.getFirstName());
			dbCandidate.setLastName(dtoCandidateIU.getLastName());
			dbCandidate.setPosition(dtoCandidateIU.getPosition());
			dbCandidate.setMilitaryStatus(dtoCandidateIU.getMilitaryStatus());
			dbCandidate.setNoticePeriod(dtoCandidateIU.getNoticePeriod());
			dbCandidate.setPhone(dtoCandidateIU.getPhone());
			dbCandidate.setEmail(dtoCandidateIU.getEmail());
			dbCandidate.setCv(dtoCandidateIU.getCv());
			
			Candidate candidate = candidateRepository.save(dbCandidate);
			DtoCandidate response = new DtoCandidate();
			BeanUtils.copyProperties(candidate, response);
			return response;
		}		
		return null;
	}

	@Override
	public void deleteCandidate(Integer id) {
		Optional<Candidate> candidateOptional = candidateRepository.findById(id);
		if(candidateOptional.isPresent()) {
			candidateRepository.delete(candidateOptional.get());
		}
	}

}
