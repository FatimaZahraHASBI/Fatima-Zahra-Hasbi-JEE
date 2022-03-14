package com.example.tp5jpa;

import com.example.tp5jpa.entities.Role;
import com.example.tp5jpa.entities.User;
import com.example.tp5jpa.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Tp5JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp5JpaApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            User u=new User();
            u.setUsername("user1");
            u.setPassword("123456");
            userService.addNewUser(u);

            User u2=new User();
            u2.setUsername("admin");
            u2.setPassword("123456");
            userService.addNewUser(u2);

            Stream.of("Student", "User", "Admin").forEach(r->{
                Role role1=new Role();
                role1.setRoleName(r);
                userService.addNewRole(role1);
            });

            userService.addRoleToUser("user1", "Student");
            userService.addRoleToUser("user1", "User");
            userService.addRoleToUser("admin", "Admin");
            userService.addRoleToUser("admin", "User");

            try{
                User user = userService.authenticate("user1", "123456");
                System.out.println(user.getUserId());
                System.out.println(user.getUsername());
                user.getRoles().forEach(r->{
                    System.out.println("Roles=>"+r);
                });
            }catch(Exception exception){
                System.out.println(exception.getMessage());
            }


        };
    }

}
