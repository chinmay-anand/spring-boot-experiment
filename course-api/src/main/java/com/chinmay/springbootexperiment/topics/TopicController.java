package com.chinmay.springbootexperiment.topics;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		//Once server is started,check http://localhost:8080/topics in browser
		return Arrays.asList(
				new Topic("mathematics", "Mathematics Course", "Mathematics course description"),
				new Topic("english", "English Course", "English course description"),
				new Topic("spring", "Spring Boot Course", "Spring Boot course description"),
				new Topic("java", "Java Course", "Java course description")
				);
	}
}
