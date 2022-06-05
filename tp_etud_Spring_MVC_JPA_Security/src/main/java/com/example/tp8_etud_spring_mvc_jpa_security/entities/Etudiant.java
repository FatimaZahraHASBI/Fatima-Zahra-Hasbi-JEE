package com.example.tp8_etud_spring_mvc_jpa_security.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 3, max = 40)
    private String nom;
    @Size(min = 3, max = 40)
    private String prenom;
    private String email;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private boolean enRegle;

}
