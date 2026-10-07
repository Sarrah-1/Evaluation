package ma.ens.service;

import ma.ens.beans.Contrat;
import ma.ens.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;
public class ContratService extends AbstractFacade<Contrat>{
    public ContratService() {
        super(Contrat.class);
    }

    public List<Contrat> findByClientCin(String cin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Contrat> query = session.createNamedQuery("Contrat.findByClientCin", Contrat.class);
            query.setParameter("cin", cin);
            return query.list();
        } finally {
            session.close();
        }
    }
    public List<Contrat> findByAssuranceType(String type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Contrat> query = session.createNamedQuery("Contrat.findByAssuranceType", Contrat.class);
            query.setParameter("type", type);
            return query.list();
        } finally {
            session.close();
        }
    }
    public List<Contrat> findActifsNonExpires(Date date) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Contrat> query = session.createNamedQuery("Contrat.findActifsNonExpires", Contrat.class);
            query.setParameter("dateDonnee", date);
            return query.list();
        } finally {
            session.close();
        }
    }

}
