package com.example.tp8_etud_spring_mvc_jpa_security.sec.service;


import com.example.tp8_etud_spring_mvc_jpa_security.sec.entities.AppRole;
import com.example.tp8_etud_spring_mvc_jpa_security.sec.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
}
