package database;

import data.Defect;
import data.DefectCategory;
import data.SimpleDefect;

import java.util.List;

public class DefectHibernateRepository implements DefectRepository {
    @Override
    public void addDefect(SimpleDefect simpleDefect) {

    }

    @Override
    public List<Defect> getDefects() {
        return null;
    }

    @Override
    public List<Defect> getDefectsByCategory(DefectCategory category) {
        return null;
    }

    @Override
    public Defect getDefect(String name) {
        return null;
    }
}
