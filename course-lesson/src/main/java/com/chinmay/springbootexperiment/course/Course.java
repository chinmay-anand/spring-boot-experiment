package com.chinmay.springbootexperiment.course;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.chinmay.springbootexperiment.topic.Topic;

//This is the model class to hold the records to be inserted to database later
@Entity
public class Course {
	@Id
	private String id;			//course identifier
	private String name;		//course name
	private String description;	//course description
	
	//ManyToOne tells about a foreign-key to be part of the current model class
	@ManyToOne
	private Topic topic;//There are many courses associated with a topic
	/**
	 * ManyToOne means "Many" of current class links to "One" of the attribute it is annotated.
	 * Default load type is EAGER, i.e. when "Course" is loaded, the child "Topic" also loads. This can result in performance issues if the child is big.
	 * pass (fetch = FetchType.LAZY) if you want the "Topic" to be loaded only when the topic member of the course object is accessed.
	 * 
	 * I get below ERROR if I try using "@ManyToOne (fetch = FetchType.LAZY)" for lazy loading
	 *    com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: java.util.ArrayList[0]->com.chinmay.springbootexperiment.course.Course["topic"]->com.chinmay.springbootexperiment.topic.Topic$HibernateProxy$zHnmUeeB["hibernateLazyInitializer"])
	 * I need to fix this for Lazy loading at a later package. I think we can do it in by
	 * 
	 * TRY: "spring.jackson.serialization.fail-on-empty-beans=false" in "applicaiton.properties"
	 * Reference: https://www.javatuto.com/spring/no-serializer-found-for-class/
	 */
	
	public Course() {
		
	}
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		//Next line actually does not create a topic instead it is needed for mapping, so that the course-topic mapping is maintained
		this.topic = new Topic(topicId, "", "");
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
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
