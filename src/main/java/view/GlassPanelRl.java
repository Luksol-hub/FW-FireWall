package view;

import defects.GlassType;

import java.awt.*;

public class GlassPanelRl extends GlassPanel {


    @Override
    void paintGlass(Graphics g) {

        g.setColor(Color.BLACK);
        int[] xPionts = {300,500,450,350};
        int[] yPionts = {100,100,300,300};
        Polygon polygon = new Polygon(xPionts,yPionts,4);
        g.fillPolygon(polygon);
    }

    @Override
    public GlassType getType() {
        return GlassType.RL;
    }
}
