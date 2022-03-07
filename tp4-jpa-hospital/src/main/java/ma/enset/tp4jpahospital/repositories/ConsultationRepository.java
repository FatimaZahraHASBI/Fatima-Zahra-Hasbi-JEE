package ma.enset.tp4jpahospital.repositories;

import ma.enset.tp4jpahospital.entities.Consultation;
import ma.enset.tp4jpahospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
