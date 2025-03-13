package com._chan.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com._chan.demo.repository.RoleRepository;
import com._chan.demo.repository.UserRepository;
import com._chan.demo.model.Role;
import com._chan.demo.model.User;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepo , UserRepository userRepo){
		return args -> {
			roleRepo.save(new Role(1, "KEK"));
			User u = new User();
		};
	}

}
