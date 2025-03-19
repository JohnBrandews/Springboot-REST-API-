package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication 
@ComponentScan(basePackages = {"io.javabrains", "api", "service", "dao", "model"})
public class MongoAmigoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MongoAmigoApplication.class, args);
	}
	
}
