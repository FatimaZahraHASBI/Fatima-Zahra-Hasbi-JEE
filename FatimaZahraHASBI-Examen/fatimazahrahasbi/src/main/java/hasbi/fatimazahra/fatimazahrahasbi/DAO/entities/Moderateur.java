package hasbi.fatimazahra.fatimazahrahasbi.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Moderateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moderateur extends Participant{
    private String specialite;
}
