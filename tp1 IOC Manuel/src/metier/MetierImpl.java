package metier;
import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;

    public double calcul() {
        double nb = dao.getValue();
        return 2 * nb;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}