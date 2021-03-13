package com.chinmay.springbootexperiment.topic;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	// SAMPLE record Topic("spring", "Spring Boot Course", "Spring Boot course description")

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topic_list = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topic_list::add);
		return topic_list;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		//"id" is already defined as key of the entity in Topic class.
		//JPA checks if a row with that id exists then it updates else it inserts.
		//No need to check for the id explicitly.
		//So for insert or update the repository method is same.
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}

}
