package view;

import javax.swing.*;
import java.awt.*;

public class GlassViewV2Rl extends GlassViewV2 {
    public GlassViewV2Rl(JFrame motherComponent) {
        super(motherComponent);
    }

    @Override
    void paintGlass(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(250,50,300, 300);
        int[] xPionts = {300,500,450,350};
        int[] yPionts = {100,100,300,300};
        g.setColor(Color.BLACK);
        Polygon polygon = new Polygon(xPionts,yPionts,4);
        g.fillPolygon(polygon);
    }
}
