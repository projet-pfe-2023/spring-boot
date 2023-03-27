package com.example.manifest;

import com.example.manifest.Entity.ERole;
import com.example.manifest.Entity.Role;
import com.example.manifest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManifestApplication {

	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManifestApplication.class, args);
	}
	//@Bean
	public CommandLineRunner commandLineRunner(){
		return args ->{
			roleRepository.save(new Role(1L, ERole.ROLE_ADMIN.toString()));
			roleRepository.save(new Role(2L, ERole.ROLE_USER.toString()));
		};
	}

}
