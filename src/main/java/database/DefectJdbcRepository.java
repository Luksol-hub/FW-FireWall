package database;

import data.Defect;
import data.DefectCategory;
import data.SimpleDefect;
import repository.DefectRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefectJdbcRepository implements DefectRepository {

    private Connection connection;

    public DefectJdbcRepository(Connection connection) {
        this.connection = connection;
    }

    public void addDefect(SimpleDefect simpleDefect) {
        try {
            Statement statement = connection.createStatement();

            String addDefect = String.format("""
                    insert into defects values(
                    	'%s',%d,%s
                    );""", simpleDefect.getName(), simpleDefect.getCategory(), simpleDefect.getPosition() + "");

            statement.execute(addDefect);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<Defect> getDefects() {

        List<Defect> defects = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String getDefect = """
                    select* from defects""";

            ResultSet resultSet = statement.executeQuery(getDefect);

            while (resultSet.next()) {
                String name = resultSet.getString("defecet_name");

                defects.add(new Defect(name, DefectCategory.values()[resultSet.getInt("category")]));
            }
            System.out.println(defects);
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
        return defects;
    }

    public List<Defect> getDefectsByCategory(DefectCategory category) {

        List<Defect> categoryDefects = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from defects where category = ?");
            int categoryNumber = category.ordinal();
            preparedStatement.setInt(1,categoryNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("defecet_name");
                categoryDefects.add(new Defect(name, category));

            }
            System.out.println(categoryDefects);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return categoryDefects;
    }

    public Defect getDefect( String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from defects where defecet_name=?");
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Defect(name,DefectCategory.values()[resultSet.getInt("category")]);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Defect> findDefectsByCategory(DefectCategory category) {
        return null;
    }

    @Override
    public void addDefects(List<Defect> defects) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
