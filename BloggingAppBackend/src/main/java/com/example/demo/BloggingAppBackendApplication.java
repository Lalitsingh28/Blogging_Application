package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.config.AppConstant;
import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepo;

@SpringBootApplication
public class BloggingAppBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BloggingAppBackendApplication.class, args);
	}
	
	@Autowired
	private RoleRepo roleRepo;
	
	
	@Override
	public void run(String... args) throws Exception {

		try {

			Role role = new Role();
			role.setId(AppConstant.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstant.NORMAL_USER);
			role1.setName("ROLE_NORMAL");

			List<Role> roles = List.of(role, role1);
			roleRepo.saveAll(roles);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
}
