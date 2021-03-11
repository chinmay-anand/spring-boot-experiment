package com.chinmay.springbootexperiment.topic;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

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
	
	public Topic getTopic(String id) {
		//Traverses thru the list of topics to get the first topic with matching id and returns it
		//If there is no match then java.util.NoSuchElementException is thrown and browser show Whitelabel Error  
		return topics.stream()
				.filter(tpc -> tpc.getId().equals(id))
				.findFirst().get();
	}
}
