package view;

import defects.Defect;
import defects.GlassDefectSection;

import java.awt.*;

import static defects.GlassDefectSection.*;
import static view.GlassPanel.*;

public class GlassDefectView extends Rectangle {

    private Defect defect;


    public GlassDefectView(int x, int y, int width, int height, Defect defect) {
        super(x, y, width, height);
        this.defect = defect;
    }

    public Defect getDefect() {
        return defect;
    }

    public GlassDefectSection getSection() {
        //todo to zabezpieczenie postawić przy wstawianiu a nie przeliczaniu
        if (x<X_POSITION || y<Y_POSITION || x > X_POSITION + WIDTH || y > Y_POSITION + HEIGHT) {
            return UNKNOWN;
        }
        if (x < X_POSITION + WIDTH / 2 &&y < Y_POSITION + HEIGHT / 3) {
            return TOP_LEFT;
        }
        if (x > X_POSITION + WIDTH / 2 && y > Y_POSITION + HEIGHT / 3) {
            return TOP_RIGHT;
        }
        if(x < X_POSITION + WIDTH / 2 && y < Y_POSITION + (HEIGHT / 3)*2){
            return MIDDLE_LEFT;
        }
        if(x > X_POSITION + WIDTH / 2){
            return MIDDLE_RIGHT;
        }
        if (x < X_POSITION + WIDTH / 2) {
            return  BOTTOM_LEFT;
        }
            return BOTTOM_RIGHT;
    }
}
