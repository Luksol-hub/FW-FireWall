package repository;

import data.Defect;
import data.DefectCategory;
import data.SimpleDefect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class DefectHibernateRepository implements DefectRepository {

    private SessionFactory sessionFactory;

    public DefectHibernateRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDefect(SimpleDefect simpleDefect) {

    }

    @Override
    public List<Defect> getDefects() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Defect> query = session.createQuery("from Defect"); // piszemy query w języku Hibernate HQL (uproszczony obiektowy SQL)
        List<Defect> defects = query.getResultList();
        transaction.commit();
        session.close();
        return defects;
    }

    @Override
    public Defect getDefect(String name) {
        return null;
    }

    @Override
    public List<Defect> findDefectsByCategory(DefectCategory category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Defect> query = session.createQuery("FROM Defect D WHERE D.defectCategory = " + category.ordinal()); // piszemy query w języku Hibernate HQL (uproszczony obiektowy SQL)
        List<Defect> defects = query.getResultList();
        transaction.commit();
        session.close();
        return defects;
    }

    @Override
    public void addDefects(List<Defect> defects) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (Defect defect : defects) {
            session.save(defect);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public boolean isEmpty() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String SQL_QUERY = "SELECT COUNT(*) FROM Defect";
        Query query = session.createQuery(SQL_QUERY);

        long row = 0;

        for(Iterator it = query.iterate(); it.hasNext();)
        {
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
}
