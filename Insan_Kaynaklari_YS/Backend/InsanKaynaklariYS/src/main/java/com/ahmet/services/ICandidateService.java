package com.ahmet.services;

import java.util.List;

import com.ahmet.dto.DtoCandidate;
import com.ahmet.dto.DtoCandidateIU;

public interface ICandidateService {	
	
	public DtoCandidate getCandidateById(Integer id);
	
	public List<DtoCandidate> getAllCandidates();
	
	public DtoCandidate createCandidate(DtoCandidateIU dtoCandidateIU);
	
	public DtoCandidate updateCandidate(Integer id, DtoCandidateIU dtoCandidateIU);
	
	public void deleteCandidate(Integer id);
}
