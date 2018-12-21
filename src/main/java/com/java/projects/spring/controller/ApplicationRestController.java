package com.java.projects.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.projects.spring.entity.Patient;
import com.java.projects.spring.service.PatientService;

@RestController
@RequestMapping("/pms")
public class ApplicationRestController {
	
	//Autowired PatientService
	@Autowired
	private PatientService patientService;
	
	//Mapping for GET /patients
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
	
	//Mapping for GET /patients/{patientId}
	@GetMapping("/patients/{patientId")
	public Patient getPatientById(@PathVariable int patientId) {
		
		Patient thePatient = patientService.getPatientById(patientId);
		
		if (thePatient == null) {
			throw new PatientNotFoundException("Patient id = " + patientId +" not found");
		}
		
		return thePatient;
	}

	//Add mapping for POST /patients -- Adding new patient
	@PostMapping("/patients")
	public Patient addOrSavePatient(@RequestBody Patient thePatient) {
		
		//Just in case to pass an id in JSON...set it to 0
		//This force save of new patient instead of update
		
		thePatient.setId(0);
		
		patientService.saveOrUpdatePatient(thePatient);
		
		return thePatient;
	}
	
	//Add mapping for PUT /patients -- update existing patient
	@PutMapping("/patients")
	public Patient updatePatient(@RequestBody Patient thePatient) {
		
		patientService.saveOrUpdatePatient(thePatient);
		
		return thePatient;
	}
	
	//Add mapping for DELETE /patients/{patientId} -- delete a patient
	@DeleteMapping("/patients/{patientId}")
	public String deletePatient(@PathVariable int patientId) {
		
		Patient tempPatient = patientService.getPatientById(patientId);
		
		//throw exception if null
		if (tempPatient == null) {
			throw new PatientNotFoundException("Patient id = " + patientId + " not found");
		}
		
		patientService.deletePatient(patientId);
		
		return "Delete patient id = " + patientId;
	}
}
