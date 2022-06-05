package com.example.tp8_etud_spring_mvc_jpa_security.sec.service;

import com.example.tp8_etud_spring_mvc_jpa_security.sec.entities.AppRole;
import com.example.tp8_etud_spring_mvc_jpa_security.sec.entities.AppUser;
import com.example.tp8_etud_spring_mvc_jpa_security.sec.repositories.AppRoleRepository;
import com.example.tp8_etud_spring_mvc_jpa_security.sec.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements SecurityService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public AppUser saveNewUser(String username, String password, String rePassword) {
        if (!password.equals(rePassword)) throw new RuntimeException("Passwords not matched");
        String hashedPWD=passwordEncoder.encode(password);
        AppUser appUser=new AppUser();
        appUser.setUserId(UUID.randomUUID().toString());
        appUser.setUsername(username);
        appUser.setPassword(hashedPWD);
        appUser.setActive(true);
        AppUser savedAppUser = appUserRepository.save(appUser);
        return savedAppUser;
    }


    @Override
    public AppRole saveNewRole(String roleName, String description) {
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole!=null) throw new RuntimeException("Role "+roleName+" already exists");
        appRole = new AppRole();
        appRole.setRoleName(roleName);
        appRole.setDescription(description);
        AppRole savedAppRole = appRoleRepository.save(appRole);
        return savedAppRole;
    }


    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) throw new RuntimeException("User not found");
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole == null) throw new RuntimeException("Role not found");
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) throw new RuntimeException("User not found");
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole == null) throw new RuntimeException("Role not found");
        appUser.getAppRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) throw new RuntimeException("User not found");
        return appUser;
    }
}
