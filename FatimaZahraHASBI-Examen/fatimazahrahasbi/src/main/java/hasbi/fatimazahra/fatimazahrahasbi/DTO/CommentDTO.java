package hasbi.fatimazahra.fatimazahrahasbi.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDTO {
    private Long id;
    private Date date;
    private String contenu;
    private int nblike;
}
