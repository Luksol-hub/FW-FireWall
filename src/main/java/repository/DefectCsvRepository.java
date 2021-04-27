package repository;

import data.Defect;
import data.DefectCategory;
import data.DefectCsvLoader;
import java.util.ArrayList;
import java.util.List;


public class DefectCsvRepository {
    private List<Defect> defects = new ArrayList<>();


    public DefectCsvRepository() {
        DefectCsvLoader defectCsvLoader = new DefectCsvLoader();
        defects.addAll(defectCsvLoader.load());
    }


    public List<Defect> findDefectsByCategory(DefectCategory defectCategory) {
        List<Defect> defectForGlass = new ArrayList<>();
        for (Defect defect : defects) {
            if (defectCategory == defect.getDefectCategory()) {
                defectForGlass.add(defect);
            }
        }
        return defectForGlass;
    }

}
