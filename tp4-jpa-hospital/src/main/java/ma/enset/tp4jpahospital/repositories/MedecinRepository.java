package ma.enset.tp4jpahospital.repositories;

import ma.enset.tp4jpahospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name);
}
