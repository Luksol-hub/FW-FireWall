package defects;

import defects.Defect;
import defects.DefectCategory;
import defects.SimpleDefect;

import java.util.List;

public interface DefectRepository {

     void addDefect(SimpleDefect simpleDefect);

     List<Defect> getDefects();

     Defect getDefect( String name);

     List<Defect> findDefectsByCategory(DefectCategory category);

     void addDefects(List<Defect> defects);

     boolean isEmpty();
}
