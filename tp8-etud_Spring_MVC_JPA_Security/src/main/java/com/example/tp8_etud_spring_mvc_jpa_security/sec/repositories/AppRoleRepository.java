package com.example.tp8_etud_spring_mvc_jpa_security.sec.repositories;

import com.example.tp8_etud_spring_mvc_jpa_security.sec.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
