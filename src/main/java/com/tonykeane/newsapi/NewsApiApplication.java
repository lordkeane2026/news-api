package com.tonykeane.newsapi;

import com.tonykeane.newsapi.entity.ApplicationUser;
import com.tonykeane.newsapi.entity.Role;
import com.tonykeane.newsapi.repository.RoleRepository;
import com.tonykeane.newsapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class NewsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsApiApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
            Role adminRole = roleRepository.save(new Role("ADMIN"));
            roleRepository.save(new Role("USER"));

            Set<Role> roles  = new HashSet<>();
            roles.add(adminRole);
            ApplicationUser admin = new ApplicationUser(1,"admin",passwordEncoder.encode("password"),roles);
            userRepository.save(admin);
        };
    }
}
