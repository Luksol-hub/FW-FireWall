package view;

import data.Defect;
import data.DefectCategory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;


public class GlassControlView extends View implements MouseListener {

    private JButton okButton = new JButton("OK");
    private JButton nokButton = new JButton("NOK");
    private JButton repairButton = new JButton("Przeróbka");
    private JButton backButton = new JButton("Cofnij");
//    private Color c = Color.BLUE;

    private JPanel panel = new JPanel(null);
    private DefaultListModel<Defect> defects = new DefaultListModel<>();
    private JComboBox<DefectCategory> categorySelector = new JComboBox<>(DefectCategory.values());
    private GlassView glassView;



    public GlassControlView(GlassView glassView) throws HeadlessException {
        super("kontrola szyby", 600, 600);
        this.glassView = glassView;
        initView();

    }

    @Override
    void initComponents() {
        add(panel);
        panel.setBounds(0,0,600,600);
        initGoodGlass();
        initDamageGlassButton();
        initProcessingButton();
        initBackButton();
        initList();
        initCategorySelector();
        comboBoxTest(); // TODO remove
        initGlassView();


    }

    private void initGoodGlass() {
        panel.add(okButton);
        okButton.setBounds(450, 420, 100, 100);
        okButton.repaint();

    }

    private void initDamageGlassButton() {
        panel.add(nokButton);
        nokButton.setBounds(350, 420, 100, 100);
        nokButton.repaint();
    }

    private void initProcessingButton() {
        panel.add(repairButton);
        repairButton.setBounds(250, 420, 100, 100);
        repairButton.repaint();
    }

    private void initBackButton() {
        panel.add(backButton);
        backButton.setBounds(50, 420, 100, 100);
        backButton.repaint();

    }

    public void initGlassView()  {

//        panel.add(glassView);
        panel.add(new GlassViewV2Rl(this));
        glassView.setBounds(0,0, 600,600);

       // panel.repaint();
    }

//    public void initDefectPoint() {
//        panel.add(glassView);
//        glassView.setBounds(300, 115, 200, 170);
////        defectPointView.setBackground(c);
//
//        panel.repaint();
//    }

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
        backButton.addActionListener(actionListener);
    }

    public void addActionSelection(ActionListener actionListener5) {
        categorySelector.addActionListener(actionListener5);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click on glass control");
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


