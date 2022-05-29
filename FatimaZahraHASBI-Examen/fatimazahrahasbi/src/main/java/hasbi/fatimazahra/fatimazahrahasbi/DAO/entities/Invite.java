package hasbi.fatimazahra.fatimazahrahasbi.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Invite")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invite extends Participant{
    private String affiliation;
}
