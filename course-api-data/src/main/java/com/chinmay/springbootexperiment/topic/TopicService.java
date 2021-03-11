package com.chinmay.springbootexperiment.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<Topic>( 
			Arrays.asList(
				new Topic("mathematics", "Mathematics Course", "Mathematics course description"),
				new Topic("english", "English Course", "English course description"),
				new Topic("spring", "Spring Boot Course", "Spring Boot course description"),
				new Topic("javascript", "Javascript Course", "Javascript course description")
			));
	//Arrays.asList() returned list is not editable
	//We used new ArrayList() makes a copy of the result of Arrays.asList() to make it mutable / editable

	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		// Traverses thru the list of topics to get the first topic with matching id and returns it
		//If there is no match then java.util.NoSuchElementException is thrown which we can catch and handle (may be return an empty constructor  
		try {
			return topics.stream()
					.filter(tpc -> tpc.getId().equals(id))
					.findFirst().get();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			//If not handled, "Whitelabel Error" is returned by the underlying tomcat.
		}
		return new Topic();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		//Arrays.asList() returns an IMMUTABLE object which can't be modified
		//So we need to get an object our of it using new ArrayList<> wchich can be modified
	}

	public void updateTopic(String id, Topic topic) {
		for (int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

}
