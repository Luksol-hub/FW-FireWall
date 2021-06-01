package controller;

import defects.DefectCategory;
import defects.DefectRepository;
import defects.GlassDefect;
import view.GlassControlView;
import view.GlassDefectView;
import view.GlassPanel;
import view.ViewFactory;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.Deque;

public class GlassControlController {
    private GlassControlView glassControlView;
    private ViewFactory viewFactory;
    private GlassPanel glassPanel; // todo poprawić nazwy
    private DefectRepository defectRepository;

    public GlassControlController(GlassControlView glassControlView, ViewFactory viewFactory, GlassPanel glassPanel, DefectRepository defectRepository) {
        this.glassControlView = glassControlView;
        this.viewFactory = viewFactory;
        this.glassPanel = glassPanel;
        this.defectRepository = defectRepository;
        this.glassControlView.lockDefectSelection();
        glassPanel.setEnabled(false);
        addActions();
        updateDefects(DefectCategory.FLOAT);
    }
    private void addActions() {
        ActionListener actionListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               actionOk();
            }
        };
        ActionListener actionListener2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actionNok();
            }
        };
        ActionListener actionListener3 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actionBack();
            }
        };
        ActionListener actionListener4 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actionMenu();
            }
        };
        ActionListener actionListener5 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDefects(glassControlView.selectedCategory());
            }
        };
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               typeModelAction();
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                actionDefectSelected();
            }
        };

        glassControlView.addActionOk(actionListener);
        glassControlView.addActionNok(actionListener2);
        glassControlView.addActionBack(actionListener3);
        glassControlView.addActionMenu(actionListener4);
        glassControlView.addActionSelection(actionListener5);
        glassControlView.addTypeModelAction(keyListener);
        glassControlView.addActionSelectedDefect(listSelectionListener);
    }

    public void actionOk() {
        Deque<GlassDefectView> defectViews = glassPanel.getDefectViews();
        for (GlassDefectView glassDefectView : defectViews) {
            GlassDefect glassDefect = new GlassDefect(glassDefectView.getDefect(), glassDefectView.getSection() );
            System.out.println(glassDefect);
            System.out.println(glassDefectView);
            // todo dodać do glassdefectrepository
        }
    }

    public void actionNok() { System.out.println("NOK");}

    public void actionBack() {
        glassPanel.back();
    }

    public void actionMenu() {
            glassControlView.dispose();
            viewFactory.createWindowSelection();
    }

    public void typeModelAction() {
        glassControlView.unlockDefectSelection();
    }

    public void updateDefects(DefectCategory category) {
        glassControlView.setDefects(defectRepository.findDefectsByCategory(category));
    }
    public void actionDefectSelected() {
        glassPanel.setEnabled(true);
    }


}
