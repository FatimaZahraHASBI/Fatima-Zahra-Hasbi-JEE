package com.example.demo1patientsmvc.repositories;

import com.example.demo1patientsmvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    public List<Patient> findByMalade(Boolean m);
    Page<Patient> findByMalade(boolean m , Pageable pageable);
    List<Patient> findByMaladeAndScoreLessThan(boolean m , int score);
    List<Patient> findByMaladeIsFalseAndScoreLessThan(int score);
    List<Patient> findByNomContains(String kw, Pageable pageable);
    @Query("select p from Patient p where p.dateNaissance between :x and :y or p.nom like :z")
    public List<Patient> FindPatients(@Param("x") Date d1, @Param("y")  Date d2, @Param("z")  String nom);
}
