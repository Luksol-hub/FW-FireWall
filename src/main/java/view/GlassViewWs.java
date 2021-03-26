package view;

import java.awt.*;

public class GlassViewWs extends GlassView {

    @Override
    void paintGlass(Graphics g) {
        int[] xPionts = {350,450,500,300};
        int[] yPionts = {125,125,275,275};
        g.setColor(Color.BLACK);
        Polygon polygon = new Polygon(xPionts,yPionts,4);
        g.fillPolygon(polygon);

    }
}
