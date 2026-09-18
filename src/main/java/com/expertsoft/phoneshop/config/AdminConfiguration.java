package com.expertsoft.phoneshop.config;

import com.expertsoft.phoneshop.enums.Role;
import com.expertsoft.phoneshop.persistence.model.User;
import com.expertsoft.phoneshop.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
public class AdminConfiguration {
    @Resource
    private UserService userService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Value("${admin.username}")
    private String username;
    @Value("${admin.password}")
    private String password;

    @Bean
    public CommandLineRunner initAdmin() {
        return args -> {
            if (userService.findByLogin("admin").isEmpty()) {
                User admin = new User();
                admin.setLogin(username);
                admin.setPassword(passwordEncoder.encode(password));
                admin.setRole(Role.ADMIN);
                admin.setName("Admin");
                userService.createUser(admin);
            }
        };
    }
}
