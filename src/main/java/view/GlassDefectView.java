package view;

import defects.Defect;

import java.awt.*;

public class GlassDefectView extends Rectangle {

    private Defect defect;

    public GlassDefectView(int x, int y, int width, int height, Defect defect) {
        super(x, y, width, height);
        this.defect = defect;
    }
}
