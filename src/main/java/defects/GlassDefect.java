package defects;

import javax.persistence.*;

@Entity
public class GlassDefect {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Defect defect;
    private GlassDefectSection section;

    public GlassDefect(Defect defect, GlassDefectSection section) {
        this.defect = defect;
        this.section = section;
    }

    public GlassDefect() {
    }

    @Override
    public String toString() {
        return "GlassDefect{" +
                "defect=" + defect +
                ", section=" + section +
                '}';
    }

}

