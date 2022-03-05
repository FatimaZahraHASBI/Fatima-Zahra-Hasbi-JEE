package ma.enset.tp3jpa;

import ma.enset.tp3jpa.entities.Patient;
import ma.enset.tp3jpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp3JpaApplication implements CommandLineRunner {
    @Autowired
    PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tp3JpaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("------------------------------------------------------------------------------------");

        //Filling the database with random data
        for (int i=0;i<100;i++){
            patientRepository.save(new Patient(null,"Fatima Zahra",new Date(), Math.random() < 0.5,44));
        }

        // fetching all Patient data
        List<Patient> patients = patientRepository.findAll();

        // displaying ALL
        for (Patient p : patients) {
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println(p.getScore());
            System.out.println("###########################");
        }
        // Fetching ALL MALADE = FALSE
        List<Patient> byMalade = patientRepository.findByMalade(false);
        System.out.println("------ Patients PAS Malades ------");
        for (Patient p : byMalade) {
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println(p.getScore());
            System.out.println("###########################");
        }
        // Fetching ALL MALADE = FALSE
        byMalade = patientRepository.findByMalade(true);
        System.out.println("------ Patients Malades ------");
        for (Patient p : byMalade) {
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println(p.getScore());
            System.out.println("###########################");
        }


        // Using @QUERY
        List<Patient> byDate = patientRepository.FindPatients(new Date(2022, Calendar.FEBRUARY,27),new Date(2022, Calendar.MAY,1),"Fatima Zahra");
        System.out.println("------ Patients between dates ------");
        for (Patient p : byDate) {
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println(p.getScore());
            System.out.println("###########################");
        }

    }
}


