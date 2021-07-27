package defects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class GlassDefectRepository {

    private SessionFactory sessionFactory;

    public GlassDefectRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Defect> getDefects() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Defect> query = session.createQuery("from Defect"); // piszemy query w języku Hibernate HQL (uproszczony obiektowy SQL)
        List<Defect> defects = query.getResultList();
        transaction.commit();
        session.close();
        return defects;
    }

    public Defect getDefect(String name) {
        return null;
    }

    public List<Defect> findDefectsByCategory(DefectCategory category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Defect> query = session.createQuery("FROM Defect D WHERE D.defectCategory = " + category.ordinal()); // piszemy query w języku Hibernate HQL (uproszczony obiektowy SQL)
        List<Defect> defects = query.getResultList();
        transaction.commit();
        session.close();
        return defects;
    }

    public void addDefects(List<GlassDefect> defects) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (GlassDefect defect : defects) {
            session.save(defect);
        }
        transaction.commit();
        session.close();
    }

    public boolean isEmpty() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String SQL_QUERY = "SELECT COUNT(*) FROM Defect";
        Query query = session.createQuery(SQL_QUERY);

        long row = 0;

        for (Iterator it = query.iterate(); it.hasNext(); ) {
            row = (Long) it.next();
            System.out.print("Count: " + row);
        }
        session.getTransaction().commit();
        session.close();
        if (row != 0) {
            return false;
        }
        return true;
    }

    public void delete(GlassDefect defect) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(defect);
        transaction.commit();
        session.close();
    }
}
