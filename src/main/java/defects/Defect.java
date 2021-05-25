package defects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "defects")
public class Defect {
    @Id
    @GeneratedValue
    private int id;
    private String kind;
    private DefectCategory defectCategory;

    public Defect(){

    }

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
