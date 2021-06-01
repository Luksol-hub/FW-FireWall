package defects;

public class GlassDefect {

    private Defect defect;
    private GlassDefectSection section;

    public GlassDefect(Defect defect, GlassDefectSection section) {
        this.defect = defect;
        this.section = section;
    }

    @Override
    public String toString() {
        return "GlassDefect{" +
                "defect=" + defect +
                ", section=" + section +
                '}';
    }

}

