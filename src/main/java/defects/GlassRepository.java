package defects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GlassRepository {
    private SessionFactory sessionFactory;

    public GlassRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addGlass(Glass glass) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(glass);
        transaction.commit();
        session.close();
    }

    public void deleteGlass(Glass glass) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(glass);
        transaction.commit();
        session.close();
    }
}
