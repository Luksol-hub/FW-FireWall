package database;

import defects.SimpleDefect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DemoDb {
    public static void main(String[] args) {

        SimpleDefect simpleDefect = new SimpleDefect("Jabłko1234",1,2.2);

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(simpleDefect);
        transaction.commit();
        session.close();

//        DefectRepository repository = new DefectHibernateRepository();
//        repository.addDefect(simpleDefect);
    }


/*
        try {
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/glasses","root","MySQL");
            String createTable = """
                    create table defects(
                    defecet_name varchar(20),
                    category int,
            position dec(3,2));""";
            String addDefect = """
                    insert into defects values(
                    	'nici',3,3.3
                    );""";

//           Statement statement = connection.createStatement();
//           statement.execute(createTable);
//           statement.execute(addDefect);
           DefectJdbcRepository defectJdbcRepository = new DefectJdbcRepository(connection);
//           defectJdbcRepository.addDefect(simpleDefect);
           defectJdbcRepository.getDefects();
           defectJdbcRepository.getDefectsByCategory(DefectCategory.SURFACE);
            Defect defect = defectJdbcRepository.getDefect("nici");
            System.out.println(defect);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/
}
