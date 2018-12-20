package com.java.projects.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


//Map entity class to database table
@Entity
@Table(name ="patients")
public class Patient implements Serializable {
	
	//Map to appropriate column in table patients
	// name is the column name in database
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="address")
	private String address;
	
	/**********Constructor, getter and setter  *************************/
	//default constructor
	public Patient() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		if (middleName != null) {
			return middleName;
		}else 
			middleName = middleName + ' ';
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	//ToString method
		@Override
		public String toString() {
			return "Patient [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName
					+ ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", address="
					+ address + "]";
		}	
		
		//Patient full name
		public String patientFullName() {
			String fullName;
			if(middleName  != null) {
				fullName = firstName + " " + middleName + " " + lastName;
			}else {
				middleName = middleName + " ";
				fullName = firstName + " " + middleName + " " + lastName;
			}
			
			
			return fullName;
		}	
	
	

}
