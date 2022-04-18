package com.example.tp8_etud_spring_mvc_jpa_security.repositories;

import com.example.tp8_etud_spring_mvc_jpa_security.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

}
