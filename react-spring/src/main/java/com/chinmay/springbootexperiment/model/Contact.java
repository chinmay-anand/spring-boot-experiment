package com.chinmay.springbootexperiment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import lombok.Data;

//@Data
@Entity
public class Contact {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String email;

	//Empty constructor
	public Contact() {}

	//Constructor to return a anew contact.
	public Contact(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	/**
	 * Model class annotation with @Data (lombok.Data), it was supposed to handle getters and setters without explicitly being defined.
	 * But it required the attributes to be "public" which is a security risk.
	 * So I opted to define getters and setters (without using lombok.Data). It worked.
	 * Alternately we could have simply made the attributes public and ot would have worked.
	 * It worked means: in postman I was able to see the two records   
	 * @return
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
