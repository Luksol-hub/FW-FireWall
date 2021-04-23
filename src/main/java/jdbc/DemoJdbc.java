package jdbc;

import data.Defect;
import data.DefectCategory;
import data.SimpleDefect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJdbc {
    public static void main(String[] args) {

        SimpleDefect simpleDefect = new SimpleDefect("szczerba",1,2.2);


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
    }
}
