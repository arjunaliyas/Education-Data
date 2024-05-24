package com.example.education.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="educationdetails",schema = "education")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private Long Id;
	
	@Column(name="candidateid")
	private Long candidateId;
	
	@Column(name="qualification")
	private Integer qualification;
	
	@Column(name="county")
	private String country;
	
	@Column(name="state")
	private String state;
	
	


}
