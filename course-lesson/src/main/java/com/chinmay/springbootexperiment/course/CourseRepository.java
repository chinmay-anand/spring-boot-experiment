package com.chinmay.springbootexperiment.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
	List<Course> findByTopicId(String selected_topic_id);
	/**
	 * Method convention:
	 * 		SYNTAX: List<ReturnModelClass>	findByProperty(prop_datatype my_property) 
	 * 				OR 						findByMemberclassAttribute(prop_datatype my_property)  
	 * 		1. Camel-case
	 * 		2. The method declaration name should start with "findBy" to use as where condition
	 * 		3. Next portion of method name is a camel-cased attribute name if it is a direct attribute of the model.
	 *  			OR it can have member class name before the attribute name.
	 *  	e.g.: List<Course> findByDescription(myVal) -- returns the list of "Course"s whose "description" field matches with "myVal"
	 *  	OR    List<Course> findByTopicId(myVal) -- returns the list of "Course"s whose "topic.id" value matches with "myVal"
	 *  				Remember that "topic" is a class member of model "Course" and "id" is a member of topic.
	 *  			The argument name may be anything but the argument type must match with the filtering field.
	 * 
	 * The CrudRepository extension interface allows us to write the custom finder methods
	 * declared in a particular naming convention so the CrudRepository does the default implementation. 
	 * for it, without our need to define the method explicitly.
	 * 
	 * In addition to pre-defined methods we can declare our custom methods as explained above
	 * 
	 */
}
