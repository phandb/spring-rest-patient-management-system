package com.java.projects.spring.dao;

import java.util.List;

import com.java.projects.spring.entity.Patient;

public interface PatientDAO {
	
	public List<Patient> getAllPatients();
	
	public void saveOrUpdatePatient(Patient thePatient);
	
	public Patient getPatientById(int patientId);
	
	public void deletePatient(int patientId);

}
