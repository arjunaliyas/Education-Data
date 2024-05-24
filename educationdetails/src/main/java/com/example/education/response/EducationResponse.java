package com.example.education.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationResponse {
	
	private Long Id;
	private Long candidateId;
	private int qualification;
	private String state;
	private String country;
	
	
	
	
	
	
	
}
