package hasbi.fatimazahra.fatimazahrahasbi.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class ConferenceDTO {
    private Long id;
    private Date date;
    private String heureDebut;
    private String heureFin;
}
