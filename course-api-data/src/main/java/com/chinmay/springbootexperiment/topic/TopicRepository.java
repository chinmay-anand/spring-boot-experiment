package com.chinmay.springbootexperiment.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
	//All out-of-box crud operations are now available form "Topic" type class withotu any explicit implementatin from our side
}
