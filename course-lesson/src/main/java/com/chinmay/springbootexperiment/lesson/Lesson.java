package com.chinmay.springbootexperiment.lesson;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.chinmay.springbootexperiment.course.Course;

//This is the model class to hold the records to be inserted to database later
@Entity
public class Lesson {
	@Id
	private String id;			//course identifier
	private String name;		//course name
	private String description;	//course description
	
	//ManyToOne tells about a foreign-key to be part of the current model class
	@ManyToOne
	private Course course;//There are many lessons associated with a course
	
	public Lesson() {
		
	}
	public Lesson(String id, String name, String description, String courseId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		//Next line actually does not create a topic instead it is needed for mapping, so that the course-topic mapping is maintained
		this.course = new Course(courseId, "", "", "");
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
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
