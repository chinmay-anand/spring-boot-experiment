package com.chinmay.springbootexperiment.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinmay.springbootexperiment.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses") 
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	/**
	 * Here "id" is the primary key of courses table, and topicId is the parent topic's id and this topicId is shared in coursetable. 
	 * @param id
	 * @return
	 */
	@RequestMapping("/topics/{topicId}/courses/{id}") 
	public Course getCourse(@PathVariable String id) {
		//This "id" being the primary key of course we can ignore topicId 
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		//Just creating the relation in course table, no topic is created, topic table remains unchanged
		courseService.addCourse(course);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		//Just creating the relation in course table, not topic is created, topic table remains unchanged
		courseService.updateCourse(course);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicid}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

}
