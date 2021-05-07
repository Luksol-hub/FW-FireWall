package repository;

import data.Defect;
import data.DefectCategory;
import data.SimpleDefect;

import java.util.List;

public interface DefectRepository {

     void addDefect(SimpleDefect simpleDefect);

     List<Defect> getDefects();

     Defect getDefect( String name);

     List<Defect> findDefectsByCategory(DefectCategory category);

     void addDefects(List<Defect> defects);
}