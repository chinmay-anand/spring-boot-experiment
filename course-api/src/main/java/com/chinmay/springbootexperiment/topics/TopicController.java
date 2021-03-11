package com.chinmay.springbootexperiment.topics;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@RequestMapping("/topics") 
	public List<Topic> getAllTopics() {
		/** 
		 *  In @RequestMapping("/topics")  annotation, URI is "/topics" and default method is "GET". For PUT, POST etc we need to explicitly specify
		 *  Once server is started, test it using http://localhost:8080/topics in browser
		 *  The result will eb a json representation of the Topic list.
		 *  The Java object to json conversion was taken care by Spring MVC.
		 *  
		 */
		return Arrays.asList(
				new Topic("mathematics", "Mathematics Course", "Mathematics course description"),
				new Topic("english", "English Course", "English course description"),
				new Topic("spring", "Spring Boot Course", "Spring Boot course description"),
				new Topic("java", "Java Course", "Java course description")
				);
	}
}
