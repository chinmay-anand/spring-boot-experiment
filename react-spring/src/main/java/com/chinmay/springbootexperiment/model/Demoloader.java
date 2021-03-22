package com.chinmay.springbootexperiment.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Demoloader implements CommandLineRunner{
	//Unless we register the class as "@Component" the class will not load run method will not invoked, so records will not be inserted 
	private final ContactRepository repo;
	private static final Logger logger =  LoggerFactory.getLogger(Demoloader.class);

	@Autowired
	public Demoloader(ContactRepository repo) {
		this.repo = repo;
	}

	@Override
	public void run(String... args) throws Exception {
		this.repo.save(new Contact("Chinmay", "Anand", "c.a@me.com"));
		this.repo.save(new Contact("Raghu", "Yadav", "r.y@you.com"));
		logger.info("Inserted 2 records into database, ~Chinmay");
	}
}
