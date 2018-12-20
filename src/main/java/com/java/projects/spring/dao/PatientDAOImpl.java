package com.java.projects.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.projects.spring.entity.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Patient> getAllPatients() {
		
		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query---sort by last name
		Query<Patient> theQuery = currentSession.createQuery("from Patient order by lastName", Patient.class);
		
		//execuete query and get result list
		List<Patient> patients = theQuery.getResultList();
		
		//return the results
		return patients;
	}

	@Override
	public void saveOrUpdatePatient(Patient thePatient) {

		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save or update the patient
		currentSession.saveOrUpdate(thePatient);

	}

	@Override
	public Patient getPatientById(int patientId) {

		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve or read patient using the primary key id
		Patient thePatient = currentSession.get(Patient.class, patientId);
		
		return thePatient;
	}

	@Override
	public void deletePatient(int patientId) {

		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object with primary key id
		Query theQuery = currentSession.createQuery("delete from Patient where id=:theId");
		
		theQuery.setParameter("theId", patientId);
			
		theQuery.executeUpdate();

	}

}
