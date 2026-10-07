package ma.ens;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

            System.out.println("Base de données et tables générées avec succès !");

            sessionFactory.close();
        } catch (Exception e) {
            System.err.println("Échec de la création de la session : " + e);
        }
    }
}