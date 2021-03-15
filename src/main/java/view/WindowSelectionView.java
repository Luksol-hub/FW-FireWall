package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WindowSelectionView extends View {
    private JButton roofLightsButton = new JButton("RL");
    private JButton windScreenButton = new JButton("WS");
    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));

    public WindowSelectionView() throws HeadlessException {
        super("Fire Wall",550,400);
        initView();
    }

    @Override
   protected void initComponents() {
        panel.add(windScreenButton);
        panel.add(roofLightsButton);

        windScreenButton.setPreferredSize(new Dimension(200, 200));
        roofLightsButton.setPreferredSize(new Dimension(200, 200));

        add(panel);
    }

    public void addActionRooflight(ActionListener actionListener) {
        roofLightsButton.addActionListener(actionListener);
    }

    public void addActionWindScreen(ActionListener actionListener) {
        windScreenButton.addActionListener(actionListener);
    }

}
