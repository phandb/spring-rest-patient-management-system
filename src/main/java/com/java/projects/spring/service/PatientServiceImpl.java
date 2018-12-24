package com.java.projects.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.projects.spring.dao.PatientDAO;
import com.java.projects.spring.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	//need to inject patient dao
	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	@Transactional
	public List<Patient> getAllPatients() {
		
		return patientDAO.getAllPatients();
	}

	@Override
	@Transactional
	public void saveOrUpdatePatient(Patient thePatient) {

		patientDAO.saveOrUpdatePatient(thePatient);

	}

	@Override
	@Transactional
	public Patient getPatientById(int theId) {
		
		return patientDAO.getPatientById(theId);
	}

	@Override
	@Transactional
	public void deletePatient(int theId) {

		patientDAO.deletePatient(theId);

	}

}
