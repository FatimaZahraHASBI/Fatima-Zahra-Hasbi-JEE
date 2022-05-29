package hasbi.fatimazahra.fatimazahrahasbi.DAO.repositories;

import hasbi.fatimazahra.fatimazahrahasbi.DAO.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Commentaire, Long> {
}
