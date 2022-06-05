package com.example.tp8_etud_spring_mvc_jpa_security.sec.repositories;

import com.example.tp8_etud_spring_mvc_jpa_security.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
