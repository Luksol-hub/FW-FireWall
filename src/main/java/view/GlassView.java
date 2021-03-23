package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public abstract class GlassView extends JPanel implements MouseListener {
    private List<Rectangle> circles = new ArrayList<>();

    public GlassView() {
        setSize(800,800);
        addMouseListener(this);
    }

    abstract void paintGlass(Graphics g);

    @Override
    public void paintComponent(Graphics g) { // template method

        g.setColor(Color.BLUE);
        g.fillRect(250,50,300, 300);
        paintGlass(g);

        g.drawRect(300, 115, 200, 170);
        g.setColor(Color.RED);
        for (Rectangle circle : circles)
            g.drawOval((int)circle.getX(),(int)circle.getY(),(int)circle.getWidth(),(int)circle.getHeight());

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
        Rectangle circle = new Rectangle(e.getX()-5, e.getY()-5, 10, 10);
        circles.add(circle);

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Test");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Test");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Test");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Test");

    }

}
