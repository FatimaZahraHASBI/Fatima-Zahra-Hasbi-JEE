package hasbi.fatimazahra.fatimazahrahasbi.DAO.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import hasbi.fatimazahra.fatimazahrahasbi.DAO.enumType.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 15)
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Participant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String photo;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String lienProfil;
    private String specialite;
    private String affiliation;
    @OneToMany(mappedBy = "speaker",fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Conference> conferences = new ArrayList<>();
    @OneToMany(mappedBy = "participant",fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Commentaire> commentaires = new ArrayList<>();
    @OneToMany(mappedBy = "invite",fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Inscription> inscriptions = new ArrayList<>();
    @OneToMany(mappedBy = "moderateur",fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Session> sessions = new ArrayList<>();
}
