package view;

import javax.swing.*;
import java.awt.*;

abstract public class View extends JFrame {


    public View(String title, int width, int height) throws HeadlessException {
        setTitle(title);
        setSize(width, height);
    }

    protected void initView() {
      initFrame();
      initComponents();
    }

    private void initFrame() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setResizable(false);
    }

    abstract void initComponents();


}
