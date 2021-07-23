package defects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

// TODO: 22.06.2021 Przygotować pod hibernete
@Entity
public class Glass {
    @Id
    @GeneratedValue
    private int id;
    @OneToMany
    private List<GlassDefect> defects;
    private String model;
    private GlassType glassType;
    private boolean ok;

    public Glass( List<GlassDefect> defects, String model, GlassType glassType, boolean ok ) {
        this.defects = defects;
        this.model = model;
        this.glassType = glassType;
        this.ok = ok;
    }

    public Glass() {
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
