package com.chinmay.springbootexperiment.topics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@RequestMapping("/topics")
	public String getAllTopics() {
		//TODO: Next action is to replace this function to return a list of Topic java objects as json. 
		return "All Topics";
	}
}
