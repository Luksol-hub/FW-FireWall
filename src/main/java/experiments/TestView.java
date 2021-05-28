package experiments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class  TestView extends JFrame {


    public TestView() throws HeadlessException {

        setSize(800,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(null);
        JButton backButton = new JButton("TEST TEXT");

        add(panel);
        panel.add(backButton);
        backButton.setBounds(50, 50, 50, 50);
        backButton.repaint();

        GraphicPanel graphicPanel = new GraphicPanel();
        panel.add(graphicPanel);
       // panel.setBounds(300,150,300,300);
        panel.repaint();
    }
}

class GraphicPanel extends JPanel implements MouseListener{
    private List<Rectangle> circles = new ArrayList<>();



    public GraphicPanel() {
        setSize(800,800);
        addMouseListener(this);

    }

   /* @Override
    protected void paintComponent(Graphics g) {
        g.drawRect(50, 50, 100, 100);

        System.out.println("MALUJEMY");
    }*/

    @Override
    public void paint(Graphics g) {
        g.drawRect(200, 50, 100, 100);


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