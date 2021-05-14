package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

   public abstract class GlassView extends JPanel implements MouseListener {
        private List<Rectangle> circles = new ArrayList<>();
        private JFrame motherComponent;
        private boolean enabled;

        public GlassView() {
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
            g.setColor(Color.GREEN);
            g.fillRect(250,50,300, 300);
            g.setColor(Color.BLACK);
            paintGlass(g);
            g.setColor(Color.BLUE);
            g.drawRect(300, 115, 200, 170);
            g.setColor(Color.RED);

            for (Rectangle circle : circles) {
                g.drawOval((int)circle.getX(),(int)circle.getY(),(int)circle.getWidth(),(int)circle.getHeight());
            }
        }

        int counter = 0;

        @Override
        public void mouseClicked(MouseEvent e) {

            if(!enabled){
                return;
            }
            counter++;
            System.out.println("CLICK!" + counter);

            Rectangle circle = new Rectangle(e.getX()-5, e.getY()-5, 10, 10);
            setBackground(Color.RED);
            circles.add(circle);
            repaint();
            motherComponent.repaint();
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

/*    @Override
    protected void paintChildren(Graphics g) {
        g.drawRect(50, 50, 100, 100);
        System.out.println("MALUJEMY3");
    }*/

       public void setMotherComponent(JFrame motherComponent) {
           this.motherComponent = motherComponent;
       }
   }
