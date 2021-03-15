package view;

import data.Defect;
import data.DefectCategory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class GlassControlView extends View {

    private JButton okButton = new JButton("OK");
    private JButton nokButton = new JButton("NOK");
    private JButton repairButton = new JButton("Przeróbka");
    private JButton backButton = new JButton("Cofnij");

    private JPanel panel = new JPanel(null);
    private DefaultListModel<Defect> defects = new DefaultListModel<>();
    JComboBox<DefectCategory> categorySelector = new JComboBox<>(DefectCategory.values());

    public GlassControlView() throws HeadlessException {
        super("kontrola szyby", 600, 600);
        initView();
    }

    @Override
    void initComponents() {
        initGoodGlass();
        initDamageGlassButton();
        initProcessingButton();
        initBackButton();
        glassView();
        initList();
        initCategorySelector();
        comboBoxTest(); // TODO remove
    }

    private void initGoodGlass() {
        panel.add(okButton);
        okButton.setBounds(450, 420, 100, 100);
        okButton.repaint();
        add(panel);
    }

    private void initDamageGlassButton() {
        panel.add(nokButton);
        nokButton.setBounds(350, 420, 100, 100);
        nokButton.repaint();
        add(panel);
    }

    private void initProcessingButton() {
        panel.add(repairButton);
        repairButton.setBounds(250, 420, 100, 100);
        repairButton.repaint();
        add(panel);
    }

    private void initBackButton() {
        panel.add(backButton);
        backButton.setBounds(50, 420, 100, 100);
        backButton.repaint();
        add(panel);
    }

    private void glassView() {
        JButton jButton4 = new JButton("obraz szyby");
        panel.add(jButton4);
        jButton4.setBounds(250, 50, 300, 300);
        jButton4.repaint();
        add(panel);
    }

    private void initList() {
       JList<Defect> defectList = new JList<>();
        defectList.setModel(defects);
        JScrollPane scrollPane = new JScrollPane(defectList);
        panel.add(scrollPane);
        scrollPane.setBounds(50, 100, 150, 250);
        defectList.setLayoutOrientation(JList.VERTICAL);
    }

    public void setDefects(List<Defect> newDefects) {
        defects.clear();
        defects.addAll(newDefects);
    }

    public void comboBoxTest() {
        categorySelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public DefectCategory selectedCategory() {
        return (DefectCategory) categorySelector.getSelectedItem();
    }

    public void initCategorySelector() {
        panel.add(categorySelector);
        categorySelector.setBounds(50, 50, 150, 30);
    }

    public void addActionOk(ActionListener actionListener) {
        System.out.println("Add");
        okButton.addActionListener(actionListener);
    }

    public void addActionNok(ActionListener actionListener) {
        System.out.println("Nok");
        nokButton.addActionListener(actionListener);
    }

    public void addActionRepair(ActionListener actionListener) {
        System.out.println("przeróbka");
        repairButton.addActionListener(actionListener);
    }

    public void addActionBack(ActionListener actionListener) {
        System.out.println("Cofnij");
        backButton.addActionListener(actionListener);
    }

    public void addActionSelection(ActionListener actionListener5) {
        categorySelector.addActionListener(actionListener5);
    }
}
