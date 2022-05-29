package hasbi.fatimazahra.fatimazahrahasbi;

import hasbi.fatimazahra.fatimazahrahasbi.DAO.entities.*;
import hasbi.fatimazahra.fatimazahrahasbi.DAO.enumType.Genre;
import hasbi.fatimazahra.fatimazahrahasbi.DAO.repositories.InscriptionRepository;
import hasbi.fatimazahra.fatimazahrahasbi.DAO.repositories.ParticipantRepository;
import hasbi.fatimazahra.fatimazahrahasbi.DAO.repositories.SalleRepository;
import hasbi.fatimazahra.fatimazahrahasbi.DAO.repositories.SessionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class FatimazahrahasbiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FatimazahrahasbiApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            ParticipantRepository participantRepository,
            SalleRepository salleRepository,
            InscriptionRepository inscriptionRepository,
            SessionRepository sessionRepository){
        return args -> {

//            //inscription
//            Inscription inscription = new Inscription();
//            inscription.setDate(new Date());
//            inscription.setPrix(300);
//            inscription.setStatus(Status.VALIDEE);
//            inscriptionRepository.save(inscription);
//            inscriptionRepository.save(inscription);
            //creation des participants
            //invite
            Stream.of("Halima","Laila").forEach(name->{
                Invite invite=new Invite();
                invite.setName(name);
                invite.setEmail(name+"@gmail.com");
                invite.setGenre(Genre.FEMENIN);
                invite.setAffiliation(Math.random()<1?"XX":"YY");
                participantRepository.save(invite);
            });
            //speaker
                Stream.of("FatimaZahra","Hasnaa").forEach(name->{
                Speaker speaker=new Speaker();
                speaker.setName(name);
                speaker.setEmail(name+"@gmail.com");
                speaker.setGenre(Genre.FEMENIN);
                speaker.setLienProfil(Math.random()<1?"lien1":"lien2");
                participantRepository.save(speaker);
            });
            //Moderateur
                Moderateur moderateur=new Moderateur();
                moderateur.setName("Noureddine");
                moderateur.setEmail("Noureddine@gmail.com");
                moderateur.setGenre(Genre.FEMENIN);
                moderateur.setSpecialite("Directeur");
                participantRepository.save(moderateur);
            //Salle
            Salle salle = new Salle();
            salle.setName("Salle 111");
            salleRepository.save(salle);

            //session
            Session session = new Session();
            session.setName("Session 1");
            session.setModerateur(moderateur);
            session.setSalle(salle);
            sessionRepository.save(session);
        };
    }


}
