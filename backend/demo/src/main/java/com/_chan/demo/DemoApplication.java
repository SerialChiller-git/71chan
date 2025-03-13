package com._chan.demo;

import java.util.HashSet;

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
			// Save role without setting ID manually
			Role role = new Role();
			role.setAuthority("KEK");  // Assuming "authority" is the role name field
			roleRepo.save(role);
			User u = new User();
			u.setUsername("serial");
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepo.findByAuthority("KEK").get());
			u.setAuthorities(roles);
			userRepo.save(u);
		};
	}

}
