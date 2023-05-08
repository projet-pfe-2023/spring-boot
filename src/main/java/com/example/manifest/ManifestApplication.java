package com.example.manifest;

import com.example.manifest.Entity.ERole;
import com.example.manifest.Entity.Role;
import com.example.manifest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

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
			roleRepository.save(new Role(1L, ERole.ADMIN.toString()));
			roleRepository.save(new Role(2L, ERole.USER.toString()));
			roleRepository.save(new Role(3L, ERole.DOUANE.toString()));
		};
	}

}
