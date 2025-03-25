package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication 
@EnableJpaRepositories(basePackages = "dao")
@EntityScan(basePackages = {"model"})
@ComponentScan(basePackages = {"io.javabrains", "api", "service", "dao", "model"})
public class MongoAmigoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MongoAmigoApplication.class, args);
	}
	
}
