package ma.enset.tp4jpahospital.service;

import ma.enset.tp4jpahospital.entities.Consultation;
import ma.enset.tp4jpahospital.entities.Medecin;
import ma.enset.tp4jpahospital.entities.Patient;
import ma.enset.tp4jpahospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsulation(Consultation consultation);
}
