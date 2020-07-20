package com.prural.conferencedemo;

import com.prural.conferencedemo.repositories.SessionRepository;
import com.prural.conferencedemo.repositories.SpeakerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.prural.conferencedemo"})
@EnableJpaRepositories(basePackages = {"com.prural.conferencedemo.repositories"})
public class ConferenceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceDemoApplication.class, args);
	}

}
