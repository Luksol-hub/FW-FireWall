package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

   public abstract class GlassViewV2 extends JPanel implements MouseListener {
        private List<Rectangle> circles = new ArrayList<>();
        private JFrame motherComponent;

        public GlassViewV2(JFrame motherComponent) {
            this.motherComponent = motherComponent;
            setSize(800,800);
            addMouseListener(this);

        }

       abstract void paintGlass(Graphics g);

   /* @Override
    protected void paintComponent(Graphics g) {
        g.drawRect(50, 50, 100, 100);

        System.out.println("MALUJEMY");
    }*/

        @Override
        public void paintComponent(Graphics g) {
           paintGlass(g);

            g.drawRect(300, 115, 200, 170);
            g.setColor(Color.RED);

//            g.drawRect(200, 50, 100, 100);


            for (Rectangle circle : circles) {
                g.drawOval((int)circle.getX(),(int)circle.getY(),(int)circle.getWidth(),(int)circle.getHeight());
            }
            System.out.println("MALUJEMY2");
        }

        int counter = 0;

        @Override
        public void mouseClicked(MouseEvent e) {
            counter++;
            System.out.println("CLICK!" + counter);

            Rectangle circle = new Rectangle(e.getX()-5, e.getY()-5, 10, 10);
            setBackground(Color.RED);
            circles.add(circle);
            repaint();
        motherComponent.repaint();
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

/*    @Override
    protected void paintChildren(Graphics g) {
        g.drawRect(50, 50, 100, 100);
        System.out.println("MALUJEMY3");
    }*/

}
