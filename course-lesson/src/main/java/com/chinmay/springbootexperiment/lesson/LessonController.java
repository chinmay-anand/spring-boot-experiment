package com.chinmay.springbootexperiment.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinmay.springbootexperiment.course.Course;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons") 
	public List<Lesson> getAllLessons(@PathVariable String courseId) {
		return lessonService.getAllLessons(courseId);
	}
	
	/**
	 * Here "id" is the primary key of Lessons table, and courseId is the parent course's id and this courseId is shared in lesson table. 
	 * @param id
	 * @return
	 */
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}") 
	public Lesson getLesson(@PathVariable String id) {
		return lessonService.getLesson(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", "", ""));
		//Just creating the relation in course table, no topic is created, topic table remains unchanged
		lessonService.addLesson(lesson);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void updateLesson(@RequestBody Lesson lesson, @PathVariable String courseId, @PathVariable String id) {
		lesson.setCourse(new Course(courseId, "", "", ""));
		//Just creating the relation in course table, not topic is created, topic table remains unchanged
		lessonService.updateLesson(lesson);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void deleteLesson(@PathVariable String id) {
		lessonService.deleteLesson(id);
	}

/**
 * TO PASS PARAMETERS FROM URI(browser thru uicontroller) TO BACKEND (services) -- USE FOLLOWING APPROACH
In @RequestMapping annotation 
	□ Pass "GET/PUT/POST/DELETE" http methods through "method=" argument.
	□ Pass URI path through "value=" argument
In arguments of mapping custom functions
	□ Pass the variable from URI like "{id}" with argument annotation of "@PathVariable"
		® No need to pass anything to this annotation if URI variable and mapping function parameter share the same name
		® Need to pass the name of the URI variable I fit is with a different name from the mapping function parameter being annotated.
	□ Pass the Model class (MVC converts to java class from json) annotated with "@RequestBody"
 */
	
	
}
