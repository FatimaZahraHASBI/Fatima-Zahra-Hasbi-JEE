package hasbi.fatimazahra.fatimazahrahasbi.DAO.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Conference {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String heureDebut;
    private String heureFin;
    @ManyToOne
    private Participant speaker;
    @ManyToOne
    private Session session;
    @OneToMany(mappedBy = "conference",fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Commentaire> commentaires = new ArrayList<>();
}
