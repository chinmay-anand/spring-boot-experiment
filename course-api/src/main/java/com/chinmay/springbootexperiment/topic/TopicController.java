package com.chinmay.springbootexperiment.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics") 
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
		
		/**
		 * 	@RequestMapping("/topics") 
		 * is same as
		 * 	@RequestMapping(method = RequestMethod.GET, value = "/topics")
		 * because GET is the default method.
		 */
	}

	@RequestMapping("/topics/{id}") 
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		//SpringMVC converts the json to a Topic object to be used and passed to service class
		topicService.addTopic(topic);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}
