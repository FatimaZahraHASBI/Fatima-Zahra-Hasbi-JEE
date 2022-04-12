package com.example.demo1patientsmvc;

import com.example.demo1patientsmvc.entities.Patient;
import com.example.demo1patientsmvc.repositories.PatientRepository;
import com.example.demo1patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class Demo1PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo1PatientsMvcApplication.class, args);
    }

    //pour demander à ne pas executer au demarrage on met Bean comme commentaire
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            for (int i = 0; i < 20; i++) {
                patientRepository.save(new Patient(null, "Fatima Zahra ", new Date(), Math.random() < 0.5, 44));
                patientRepository.save(new Patient(null, "Achraf", new Date(), Math.random() < 0.5, 55));
                patientRepository.save(new Patient(null, "Hasnaa", new Date(), Math.random() < 0.5, 33));
                patientRepository.save(new Patient(null, "Noureddine", new Date(), Math.random() < 0.5, 66));
                patientRepository.save(new Patient(null, "Laila", new Date(), Math.random() < 0.5, 88));
                patientRepository.save(new Patient(null, "Halima", new Date(), Math.random() < 0.5, 99));
                patientRepository.save(new Patient(null, "Hamza", new Date(), Math.random() < 0.5, 22));
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
