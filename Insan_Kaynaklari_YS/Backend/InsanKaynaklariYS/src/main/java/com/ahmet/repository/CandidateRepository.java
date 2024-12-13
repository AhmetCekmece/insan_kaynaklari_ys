package com.ahmet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ahmet.entities.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
	
	@Query(value = "SELECT * FROM candidate ORDER BY id ASC" , nativeQuery=true) 
	List<Candidate> findAllCandidateAsc();
}
