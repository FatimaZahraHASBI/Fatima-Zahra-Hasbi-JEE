package presentation;
import java.io.*;import java.lang.reflect.*;
import java.util.Scanner; import metier.IMetier;
import dao.IDao;
public class Presentation {
    public static void main(String[] args) {
          //methode classique
//        DaoImpl dao=new DaoImpl();
//        MetierImpl metier=new MetierImpl();
//        metier.setDao(dao);
//        System.out.println(metier.calcul());
        //methode dynamique en lisant les noms des classes à utiliser depuis config.txt
        try {
            Scanner scanner=new Scanner(new File("src/config.txt"));
            String daoClassname=scanner.next();
            String metierClassName=scanner.next();
            Class cdao=Class.forName(daoClassname);
            IDao dao= (IDao) cdao.newInstance();
            Class cmetier=Class.forName(metierClassName);
            IMetier metier=(IMetier) cmetier.newInstance();
            Method meth=cmetier.getMethod("setDao",IDao.class);
            meth.invoke(metier,dao);
            System.out.println(metier.calcul());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
