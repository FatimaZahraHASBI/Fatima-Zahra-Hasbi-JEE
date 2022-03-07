package ma.enset.tp4jpahospital;

import ma.enset.tp4jpahospital.entities.*;
import ma.enset.tp4jpahospital.repositories.ConsultationRepository;
import ma.enset.tp4jpahospital.repositories.MedecinRepository;
import ma.enset.tp4jpahospital.repositories.PatientRepository;
import ma.enset.tp4jpahospital.repositories.RendezVousRepository;
import ma.enset.tp4jpahospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp4JpaHospitalApplication {

    public static void main(String[] args) {

        SpringApplication.run(Tp4JpaHospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository, RendezVousRepository rendezVousRepository, MedecinRepository medecinRepository){
        return args -> {
            Stream.of("Fatima Zahra", "Hasnaa", "Halima")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });

            Stream.of("Laila", "Achraf", "Noureddine")
                    .forEach(name->{
                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        medecin.setEmail(name+"@gmail.com");
                        hospitalService.saveMedecin(medecin);
                    });

            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Fatima Zahra");

            Medecin medecin=medecinRepository.findByNom("Achraf");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDateRDV(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hospitalService.saveRDV(rendezVous);


            RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);

            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRapport("Rapport de la consultation...");
            consultation.setRendezVous(rendezVous1);
            hospitalService.saveConsulation(consultation);


        };
    }

}
