package com.example.education.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.education.entity.Education;

@Repository
public interface EducationRepo extends JpaRepository<Education, Long> {

	List<Education> findByCandidateId(Long candidateId);

}
