package com.example.spring_security;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.spring_security.entities.Authority;
import com.example.spring_security.entities.User;
import com.example.spring_security.repositories.UserRepo;

@SpringBootApplication
public class SpringSecurityApplication {

	private final UserRepo userRepo;

	private final PasswordEncoder passwordEncoder;

	public SpringSecurityApplication(UserRepo userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void fetchRandomFiveQuestions() {
		Authority authority = new Authority("READ");
		User user = new User("Rishabh Rawat", "xyz@gmail.com", passwordEncoder.encode("abc"), Set.of(authority));
		userRepo.save(user);
	}

}
