package hasbi.fatimazahra.fatimazahrahasbi.DTO;

import hasbi.fatimazahra.fatimazahrahasbi.DAO.enumType.Status;
import lombok.Data;

import java.util.Date;

@Data
public class InscriptionDTO {
    private Long id;
    private Date date;
    private Status status;
    private double prix;
}
