package hasbi.fatimazahra.fatimazahrahasbi.web;

import hasbi.fatimazahra.fatimazahrahasbi.DAO.entities.*;
import hasbi.fatimazahra.fatimazahrahasbi.DAO.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class webController {
    ParticipantRepository participantRepository;
    ConferenceRepository conferenceRepository;
    InscriptionRepository inscriptionRepository;
    SessionRepository sessionRepository;
    SalleRepository salleRepository;

    @GetMapping(path = "/participants")
    public List<Participant> participants(){
        return participantRepository.findAll();
    }

    @GetMapping(path = "participants/{id}")
    public Participant getParticipant(@PathVariable Long id){
        return participantRepository.findById(id).orElse(null);
    }

    @PostMapping("/participants")
    public Participant saveParticipant(@RequestBody Participant participant){
        return participantRepository.save(participant);
    }

    @DeleteMapping("/participants/{id}")
    public void deleteParticipant(@PathVariable Long id){
        participantRepository.deleteById(id);
    }

    @GetMapping(path = "/conferences")
    public List<Conference> conferences(){
        return conferenceRepository.findAll();
    }

    @GetMapping(path = "conferences/{id}")
    public Conference getConference(@PathVariable Long id){
        return conferenceRepository.findById(id).orElse(null);
    }

    @PostMapping("/conferences")
    public Conference saveConference(@RequestBody Conference conference){
        return conferenceRepository.save(conference);
    }

    @DeleteMapping("/conferences/{id}")
    public void deleteConference(@PathVariable Long id){
        conferenceRepository.deleteById(id);
    }

    @GetMapping(path = "/inscriptions")
    public List<Inscription> inscriptions(){
        return inscriptionRepository.findAll();
    }

    @GetMapping(path = "inscriptions/{id}")
    public Inscription getInscription(@PathVariable Long id){
        return inscriptionRepository.findById(id).orElse(null);
    }

    @PostMapping("/inscriptions")
    public Inscription saveInscription(@RequestBody Inscription inscription){
        return inscriptionRepository.save(inscription);
    }

    @DeleteMapping("/inscriptions/{id}")
    public void deleteInscription(@PathVariable Long id){
        inscriptionRepository.deleteById(id);
    }

    @GetMapping(path = "/sessions")
    public List<Session> sessions(){
        return sessionRepository.findAll();
    }

    @GetMapping(path = "/sessions/{id}")
    public Session getSession(@PathVariable Long id){
        return sessionRepository.findById(id).orElse(null);
    }

    @PostMapping("/sessions")
    public Session saveSession(@RequestBody Session session){
        return sessionRepository.save(session);
    }

    @DeleteMapping("/sessions/{id}")
    public void deleteSession(@PathVariable Long id){
        sessionRepository.deleteById(id);
    }


}
