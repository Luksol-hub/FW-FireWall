package defects;

import java.util.List;

public class Glass {
    private List<GlassDefect> defects;
    private String model;
    private GlassType glassType;

    public Glass(List<GlassDefect> defects, String model, GlassType glassType) {
        this.defects = defects;
        this.model = model;
        this.glassType = glassType;
    }

    @Override
    public String toString() {
        return "Glass{" +
                "defects=" + defects +
                ", model='" + model + '\'' +
                ", glassType=" + glassType +
                '}';
    }
}
