package com.challenge.api;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ChallengeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApiApplication.class, args);
	}

	@PostConstruct
	public void startFlyWayInstance() {
		Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/challenge-fullapp", "challenge-fullapp", "challenge-fullapp").load();
		flyway.migrate();
	}
}
