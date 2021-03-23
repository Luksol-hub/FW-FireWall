package view;

import java.awt.*;
import java.awt.event.MouseEvent;

public class GlassViewWs extends GlassView{

    @Override
    void paintGlass(Graphics g) {
                        //LT /RT /RB /LB
        int[] xPionts = {350,450,500,300};
        int[] yPionts = {125,125,275,275};
        g.setColor(Color.BLACK);
        Polygon polygon = new Polygon(xPionts,yPionts,4);
        g.fillPolygon(polygon);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
