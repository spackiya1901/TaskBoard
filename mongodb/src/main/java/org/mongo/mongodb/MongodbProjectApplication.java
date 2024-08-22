package org.mongo.mongodb;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongodbProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbProjectApplication.class, args);
	}
	
	@Bean
	public AtomicInteger atomicInteger() {
		return new AtomicInteger();
	}

}
