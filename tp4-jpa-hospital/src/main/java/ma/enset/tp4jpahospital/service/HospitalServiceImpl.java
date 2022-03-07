package ma.enset.tp4jpahospital.service;

import ma.enset.tp4jpahospital.entities.Consultation;
import ma.enset.tp4jpahospital.entities.Medecin;
import ma.enset.tp4jpahospital.entities.Patient;
import ma.enset.tp4jpahospital.entities.RendezVous;
import ma.enset.tp4jpahospital.repositories.ConsultationRepository;
import ma.enset.tp4jpahospital.repositories.MedecinRepository;
import ma.enset.tp4jpahospital.repositories.PatientRepository;
import ma.enset.tp4jpahospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsulation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
