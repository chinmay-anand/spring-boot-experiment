package com.chinmay.springbootexperiment.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

//This is the model class to hold the records to be inserted to database later
@Entity
public class Topic {
	@Id
	private String id;			//course identifier
	private String name;		//course name
	private String description;	//course description
	
	public Topic() {
		
	}
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
