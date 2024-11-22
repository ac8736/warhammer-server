package dev.warhammer.celestial_orrery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CelestialOrreryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CelestialOrreryApplication.class, args);
	}

}
