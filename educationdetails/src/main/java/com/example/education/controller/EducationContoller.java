package com.example.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.education.request.EducationRequest;
import com.example.education.response.EducationResponse;
import com.example.education.service.EducationService;

@RestController
public class EducationContoller {
	@Autowired                                                                                                                                                                                                                                                                                                                                                                                                                                      
	private EducationService educationService;
	
	@PostMapping("/details")
	public ResponseEntity<String> saveEducationDetail(@RequestBody EducationRequest educationRequest){
		String saveEducationdetail= educationService.saveEducationDetail(educationRequest);
		return ResponseEntity.ok(saveEducationdetail);
	}
	
	@GetMapping("/details")
	public ResponseEntity<List<EducationResponse>> getAllEducationDetails(){
		List<EducationResponse> educationDetails = educationService.getAllEducationDetails();
		return ResponseEntity.ok(educationDetails);
	}
	
	@DeleteMapping("/details/{Id}")
	public ResponseEntity<String> deleteEducationDetail(@PathVariable Long Id){
		String res =  educationService.deleteEducationDetail(Id);
		return ResponseEntity.ok(res);
	}
	
	@PutMapping("/details/{Id}")
	public ResponseEntity<String> updateEducationDetail(@PathVariable Long Id,@RequestBody EducationRequest educationRequest){
		String response = educationService.updateEducationDetail(Id, educationRequest);
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/details/candidates/{candidateId}")
    public ResponseEntity<List<EducationResponse>> findEducationDetailsByCandidateId(@PathVariable Long candidateId) {
        List<EducationResponse> educationDetails = educationService.findEducationDetailsByCandidateId(candidateId, null);
        return ResponseEntity.ok(educationDetails);
    }
	
}
