package com.chinmay.springbootexperiment.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = Arrays.asList(
			new Topic("mathematics", "Mathematics Course", "Mathematics course description"),
			new Topic("english", "English Course", "English course description"),
			new Topic("spring", "Spring Boot Course", "Spring Boot course description"),
			new Topic("javascript", "Javascript Course", "Javascript course description")
			);

	public List<Topic> getAllTopics(){
		return topics;
	}
}
