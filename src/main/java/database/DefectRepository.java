package database;

import data.Defect;
import data.DefectCategory;
import data.SimpleDefect;

import java.util.List;

public interface DefectRepository {

     void addDefect(SimpleDefect simpleDefect);

     List<Defect> getDefects();

     List<Defect> getDefectsByCategory(DefectCategory category);

     Defect getDefect( String name);
}
