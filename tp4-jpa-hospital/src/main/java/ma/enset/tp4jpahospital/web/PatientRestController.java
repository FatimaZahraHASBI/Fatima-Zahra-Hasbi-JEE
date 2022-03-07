package ma.enset.tp4jpahospital.web;

import ma.enset.tp4jpahospital.entities.Patient;
import ma.enset.tp4jpahospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> patientList(){
        return patientRepository.findAll();
    }
}
