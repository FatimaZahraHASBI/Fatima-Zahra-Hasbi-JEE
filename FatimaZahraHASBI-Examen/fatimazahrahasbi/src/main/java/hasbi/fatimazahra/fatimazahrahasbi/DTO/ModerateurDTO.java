package hasbi.fatimazahra.fatimazahrahasbi.DTO;

import hasbi.fatimazahra.fatimazahrahasbi.DAO.enumType.Genre;
import lombok.Data;

@Data
public class ModerateurDTO {
    private Long id;
    private String name;
    private String email;
    private String photo;
    private Genre genre;
    private String specialite;
}
