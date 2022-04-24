package com.example.oauth2.config;

import com.example.oauth2.domain.AppUser;
import com.example.oauth2.domain.Role;
import com.example.oauth2.domain.RoleToUserForm;
import com.example.oauth2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Configuration
public class UserConfiguration {


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new AppUser(null, "John Travolta", "john", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Will Simth", "will", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));


            userService.addRoleToUser(new RoleToUserForm("john", "ROLE_MANAGER"));
            userService.addRoleToUser(new RoleToUserForm("john", "ROLE_MANAGER"));
            userService.addRoleToUser(new RoleToUserForm("will", "ROLE_MANAGER"));
            userService.addRoleToUser(new RoleToUserForm("jim", "ROLE_ADMIN"));
            userService.addRoleToUser(new RoleToUserForm("arnold", "ROLE_USER"));
            userService.addRoleToUser(new RoleToUserForm("arnold", "ROLE_ADMIN"));
            userService.addRoleToUser(new RoleToUserForm("arnold", "ROLE_SUPER_ADMIN"));
        };
    }
}
