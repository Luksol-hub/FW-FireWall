package view;

import defects.Defect;
import defects.DefectCategory;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class GlassControlView extends View implements MouseListener {

    private JButton okButton = new JButton("OK");
    private JButton nokButton = new JButton("NOK");
    private JButton repairButton = new JButton("Przeróbka");
    private JButton backButton = new JButton("Cofnij");
//    private Color c = Color.BLUE;

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

        panel.add(glassPanel);
//        panel.add(new GlassPanelRl(this));
        glassPanel.setBounds(0,0, 600,600);

       // panel.repaint();
    }

//    public void initDefectPoint() {
//        panel.add(glassPanel);
//        glassPanel.setBounds(300, 115, 200, 170);
////        defectPointView.setBackground(c);
//
//        panel.repaint();
//    }

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

    public void addActionSelectedDefect(ListSelectionListener listSelectionListener ) {
        defectList.addListSelectionListener(listSelectionListener);
    }

    public void addTypeModelAction(KeyListener keyListener) {
        modelName.addKeyListener(keyListener);
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


