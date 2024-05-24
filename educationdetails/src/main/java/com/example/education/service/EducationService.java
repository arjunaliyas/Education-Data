package com.example.education.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.education.request.EducationRequest;
import com.example.education.response.EducationResponse;


@Service
public interface EducationService {
	
   List<EducationResponse> getAllEducationDetails();
   String deleteEducationDetail(Long Id);
   String saveEducationDetail(EducationRequest educationRequest);
   String updateEducationDetail(Long Id,EducationRequest educationRequest);
   List<EducationResponse> findEducationDetailsByCandidateId(Long candidateId,EducationRequest educationRequest);
}
