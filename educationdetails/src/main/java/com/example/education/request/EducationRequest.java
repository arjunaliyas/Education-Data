package com.example.education.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationRequest {
	private Long candidateId;
	private int qualification;
	private String country;
	private String state;
	

}
