package view;

import defects.Defect;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public abstract class GlassPanel extends JPanel implements MouseListener {
    private Deque<GlassDefectView> defectViews = new LinkedList<>();
    private GlassControlView glassControlView;
    private boolean enabled;
    public static final int X_POSITION = 300;
    public static final int Y_POSITION = 115;
    public static final int WIDTH = 200;
    public static final int HEIGHT = 170;

    public GlassPanel() {
        setSize(800, 800);
        addMouseListener(this);
    }

    abstract void paintGlass(Graphics g);

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(250, 50, 300, 300);
        g.setColor(Color.BLACK);
        paintGlass(g);
        g.setColor(Color.BLUE);
        g.drawRect(X_POSITION, Y_POSITION, WIDTH, HEIGHT);
        g.setColor(Color.RED);

        for (Rectangle circle : defectViews) {
            g.drawOval((int) circle.getX(), (int) circle.getY(), (int) circle.getWidth(), (int) circle.getHeight());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!enabled) {
            return;
        }
        Defect defect = glassControlView.selectedDefect();
        GlassDefectView glassDefectView = new GlassDefectView(e.getX() - 5, e.getY() - 5, 10, 10,defect);
        defectViews.add(glassDefectView);
        repaint();
        glassControlView.repaint();
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public void setGlassControlView(GlassControlView glassControlView) {
        this.glassControlView = glassControlView;
    }

    public void back() {
        defectViews.pollLast();
        repaint();
        glassControlView.repaint();
    }
    public Deque<GlassDefectView> getDefectViews() {
        return defectViews;
    }
}
