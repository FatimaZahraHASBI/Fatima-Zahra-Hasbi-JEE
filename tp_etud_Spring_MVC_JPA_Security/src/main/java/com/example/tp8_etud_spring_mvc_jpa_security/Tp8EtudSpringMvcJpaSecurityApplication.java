package com.example.tp8_etud_spring_mvc_jpa_security;

import com.example.tp8_etud_spring_mvc_jpa_security.entities.Etudiant;
import com.example.tp8_etud_spring_mvc_jpa_security.entities.Genre;
import com.example.tp8_etud_spring_mvc_jpa_security.repositories.EtudiantRepository;
import com.example.tp8_etud_spring_mvc_jpa_security.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class Tp8EtudSpringMvcJpaSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp8EtudSpringMvcJpaSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository) {
        return args -> {
            for (int i = 0; i < 20; i++) {
                etudiantRepository.save(new Etudiant(null, "Hasbi", "Fatima Zahra ", "hasbi@gmail.com", new Date(), Genre.FEMENIN, true));
                etudiantRepository.save(new Etudiant(null, "Hasbi", "Achraf", "achraf@gmail.com", new Date(), Genre.MASCULIN, true));
                etudiantRepository.save(new Etudiant(null, "Hasbi", "Hasnaa", "hasnaa@gmail.com", new Date(), Genre.FEMENIN, true));
                etudiantRepository.save(new Etudiant(null, "Hasbi", "Noureddine", "noured@gmail.com", new Date(), Genre.MASCULIN, true));
                etudiantRepository.save(new Etudiant(null, "Chahi", "Laila", "Laila@gmail.com", new Date(), Genre.FEMENIN, true));
                etudiantRepository.save(new Etudiant(null, "Hasbi", "Halima", "halima@gmail.com", new Date(), Genre.FEMENIN, true));
                etudiantRepository.save(new Etudiant(null, "Dadda", "Hamza", "hamza@gmail.com", new Date(), Genre.MASCULIN, true));
            }

        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner saveUsers(SecurityService securityService) {
        return args -> {
            securityService.saveNewUser("Fatima Zahra", "1234", "1234");
            securityService.saveNewUser("Hasnaa", "1234", "1234");
            securityService.saveNewUser("Achraf", "1234", "1234");

            securityService.saveNewRole("USER", "");
            securityService.saveNewRole("ADMIN", "");

            securityService.addRoleToUser("Fatima Zahra", "USER");
            securityService.addRoleToUser("Fatima Zahra", "ADMIN");
            securityService.addRoleToUser("Hasnaa", "USER");
            securityService.addRoleToUser("Achraf", "USER");

        };

    }


}
