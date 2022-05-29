package hasbi.fatimazahra.fatimazahrahasbi.DAO.entities;

import hasbi.fatimazahra.fatimazahrahasbi.DAO.enumType.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Inscription {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double prix;
    @ManyToOne
    private Participant invite;
    @ManyToOne
    private Session session;
}
