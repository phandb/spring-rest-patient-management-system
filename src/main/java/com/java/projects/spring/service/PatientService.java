package com.java.projects.spring.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.projects.spring.entity.Patient;


public interface PatientService {
	
	public List<Patient> getAllPatients();
	
	public void saveOrUpdatePatient(Patient thePatient);
	
	public Patient getPatientById(int theId) ;
	
	public void deletePatient(int theId);

}
