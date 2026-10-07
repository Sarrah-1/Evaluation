package ma.ens.service;

import ma.ens.beans.Assurance;
import ma.ens.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class AssuranceService extends AbstractFacade<Assurance>{
    public AssuranceService() {
        super(Assurance.class);
    }
    public Assurance findByType(String type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Assurance> query = session.createQuery("FROM Assurance a WHERE a.type = :type", Assurance.class);
            query.setParameter("type", type);
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }

}



