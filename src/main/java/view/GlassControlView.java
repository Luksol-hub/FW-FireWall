package view;

import defects.Defect;
import defects.DefectCategory;
import defects.GlassType;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class GlassControlView extends View {

    private JButton okButton = new JButton("OK");
    private JButton nokButton = new JButton("NOK");
    private JButton back = new JButton("Cofnij");
    private JButton menu = new JButton("Menu");

    private DefaultListModel<Defect> defects = new DefaultListModel<>();
    private JComboBox<DefectCategory> categorySelector = new JComboBox<>(DefectCategory.values());
    private JList<Defect> defectList = new JList<>();

    private JPanel panel = new JPanel(null);
    private JTextField modelName = new JTextField();
    private JLabel notification = new JLabel();
    private GlassPanel glassPanel;


    public GlassControlView(GlassPanel glassPanel) throws HeadlessException {
        super("kontrola szyby", 600, 600);
        this.glassPanel = glassPanel;
        initView();
    }

    @Override
    void initComponents() {
        add(panel);
        panel.setBounds(0,0,600,600);
        initModelName();
        initNotification();
        initGoodGlass();
        initDamageGlassButton();
        initProcessingButton();
        initBackButton();
        initList();
        initCategorySelector();
        comboBoxTest();
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
        panel.add(back);
        back.setBounds(250, 420, 100, 100);
        back.repaint();
    }

    private void initBackButton() {
        panel.add(menu);
        menu.setBounds(50, 420, 100, 100);
        menu.repaint();
    }

    public void initGlassView()  {
        panel.add(glassPanel);
        glassPanel.setBounds(0,0, 600,600);
    }

    private void initList() {

        defectList.setModel(defects);
        JScrollPane scrollPane = new JScrollPane(defectList);
        panel.add(scrollPane);
        scrollPane.setBounds(50, 100, 150, 250);
        defectList.setLayoutOrientation(JList.VERTICAL);
    }

    private void initModelName() {
        JLabel modelLabel = new JLabel("Model");
        panel.add(modelLabel);
        modelLabel.setBounds(50,360,100,25);
        panel.add(modelName);
        modelName.setBounds(50,380,150,25);
        modelName.repaint();
    }

    private void initNotification() {
        panel.add(notification);
        notification.setBounds(150,10,200,25);
        notification.repaint();
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

    public Defect selectedDefect() {
        return defectList.getSelectedValue();
    }

    public void initCategorySelector() {
        panel.add(categorySelector);
        categorySelector.setBounds(50, 50, 150, 30);
    }

    public void lockDefectSelection() {
        categorySelector.setEnabled(false);
        defectList.setEnabled(false);
    }

    public void unlockDefectSelection() {
        categorySelector.setEnabled(true);
        defectList.setEnabled(true);
    }

    public void lockOkButtons() {
        okButton.setEnabled(false);
        nokButton.setEnabled(false);
    }

    public void unlockOkButtons() {
        okButton.setEnabled(true);
        nokButton.setEnabled(true);
    }

    public void addActionOk(ActionListener actionListener) {
        System.out.println("Add");
        okButton.addActionListener(actionListener);
    }

    public void addActionNok(ActionListener actionListener) {
        System.out.println("Nok");
        nokButton.addActionListener(actionListener);
    }

    public void addActionBack(ActionListener actionListener) {
        System.out.println("przeróbka");
        back.addActionListener(actionListener);
    }

    public void addActionMenu(ActionListener actionListener) {
        menu.addActionListener(actionListener);
    }

    public void addActionSelection(ActionListener actionListener5) {
        categorySelector.addActionListener(actionListener5);
    }

    public void addActionSelectedDefect(ListSelectionListener listSelectionListener ) {
        defectList.addListSelectionListener(listSelectionListener);
    }

    public void addTypeModelAction(KeyListener keyListener) {
        modelName.addKeyListener(keyListener);
    }

    public String getModelName() {
        return modelName.getText();
    }

    public GlassType getGlassType() {
        return glassPanel.getType();
    }

}


