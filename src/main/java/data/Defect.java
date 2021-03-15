package data;

public class Defect {
   private String kind;
   private DefectCategory defectCategory;

    public Defect(String whatKindOfDefects, DefectCategory defectCategory) {
        this.kind = whatKindOfDefects;
        this.defectCategory = defectCategory;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public DefectCategory getDefectCategory() {
        return defectCategory;
    }

    @Override
    public String toString() {
        return kind;
    }
}
