package ma.enset.tp4jpahospital.repositories;

import ma.enset.tp4jpahospital.entities.Medecin;
import ma.enset.tp4jpahospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
