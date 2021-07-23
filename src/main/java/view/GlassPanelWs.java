package view;

import defects.GlassType;

import java.awt.*;

public class GlassPanelWs extends GlassPanel {

    @Override
    void paintGlass(Graphics g) {
        int[] xPionts = {350,450,500,300};
        int[] yPionts = {125,125,275,275};
        g.setColor(Color.BLACK);
        Polygon polygon = new Polygon(xPionts,yPionts,4);
        g.fillPolygon(polygon);

    }

    @Override
    public GlassType getType() {
        return GlassType.WS;
    }
}
