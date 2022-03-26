package com.example.demo1patientsmvc;

import com.example.demo1patientsmvc.entities.Patient;
import com.example.demo1patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Demo1PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo1PatientsMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
            return args -> {
                for (int i=0;i<20;i++){
                    patientRepository.save(new Patient(null,"Fatima Zahra",new Date(), Math.random() < 0.5,44));
                }

            };
    }

}
