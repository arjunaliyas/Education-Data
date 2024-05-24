package com.example.education.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.education.entity.Education;
import com.example.education.exception.ResourceNotFoundException;
import com.example.education.repository.EducationRepo;
import com.example.education.request.EducationRequest;
import com.example.education.response.EducationResponse;
import com.example.education.service.EducationService;


@Service
public class EducationServiceImpl implements EducationService   {
	
	@Autowired
	private EducationRepo educationRepo;

	@Override
	public List<EducationResponse> getAllEducationDetails() {
		List<Education> educations=educationRepo.findAll();
		List<EducationResponse> y=new ArrayList<EducationResponse>();
		if(educations.isEmpty()) {
			throw new Error("No education details found in DB");
		}
		for(Education x:educations) {
		EducationResponse educationResponse=EducationResponse.builder()
				.Id(x.getId())
				.candidateId(x.getCandidateId())
				.qualification(x.getQualification())
				.state(x.getState())
				.country(x.getCountry()).build();
		y.add(educationResponse);
		
		}
		return y;
		
	/*	return educations.stream().map(education -> new EducationResponse(
				education.getId(),
				education.getCandidateId(),
				education.getQualification(),
				education.getState(),
				education.getCountry()
				)).collect(Collectors.toList());*/
	}

	@Override
	public String deleteEducationDetail(Long Id) {
		if(!educationRepo.existsById(Id)) {
			throw new ResourceNotFoundException("Education detail not found with id: "+Id);
		}
		
		educationRepo.deleteById(Id);
		
		return "Deleted Successfully !";
		
	}

	@Override
	public String saveEducationDetail(EducationRequest educationRequest) {
		Education education=new Education();
        education.setCandidateId(educationRequest.getCandidateId());
        education.setQualification(educationRequest.getQualification());
        education.setCountry(educationRequest.getCountry());
        education.setState(educationRequest.getState());
        
        educationRepo.save(education);
        
		return "Saved Succesfully !";
	}

	@Override
	public String updateEducationDetail(Long Id, EducationRequest educationRequest) {
		Education education=educationRepo.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Educationdetails not found with id : "+Id));
		
		
		education.setCandidateId(educationRequest.getCandidateId());
		education.setQualification(educationRequest.getQualification());
		education.setCountry(educationRequest.getCountry());
		education.setState(educationRequest.getState());
		
		educationRepo.save(education);
		
		return "Updated Successfully !";
	}

	@Override
	public List<EducationResponse> findEducationDetailsByCandidateId(Long candidateId,EducationRequest educationRequest) {
		List<Education> educations = educationRepo.findByCandidateId(candidateId);
		List<EducationResponse> y=new ArrayList<EducationResponse>();
		if(educations.isEmpty()) {
			throw new Error("No education details found in DB");
		}
		for(Education x:educations) {
		EducationResponse educationResponse=EducationResponse.builder()
				.Id(x.getId())
				.candidateId(x.getCandidateId())
				.qualification(x.getQualification())
				.state(x.getState())
				.country(x.getCountry()).build();
		y.add(educationResponse);
		
		}
		return y;
	}

	 
	
}
