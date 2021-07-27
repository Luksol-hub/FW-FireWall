package controller;

import defects.*;
import view.GlassControlView;
import view.GlassDefectView;
import view.GlassPanel;
import view.ViewFactory;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GlassControlController {
    private GlassControlView glassControlView;
    private ViewFactory viewFactory;
    private GlassPanel glassPanel; // todo poprawić nazwy
    private DefectRepository defectRepository;
    private GlassRepository glassRepository;
    private GlassDefectRepository glassDefectRepository;
    private Glass lastGlass;

    public GlassControlController(GlassControlView glassControlView, ViewFactory viewFactory, GlassPanel glassPanel, DefectRepository defectRepository, GlassRepository glassRepository, GlassDefectRepository glassDefectRepository) {
        this.glassControlView = glassControlView;
        this.viewFactory = viewFactory;
        this.glassPanel = glassPanel;
        this.defectRepository = defectRepository;
        this.glassRepository = glassRepository;
        this.glassDefectRepository = glassDefectRepository;
        glassControlView.resetView();
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
                actionBackDefect();
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
        ActionListener actionListener6 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actionBackGlass();
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
        glassControlView.addActionBackDefect(actionListener3);
        glassControlView.addActionMenu(actionListener4);
        glassControlView.addActionSelection(actionListener5);
        glassControlView.addActionBackGlass(actionListener6);
        glassControlView.addTypeModelAction(keyListener);
        glassControlView.addActionSelectedDefect(listSelectionListener);
    }

    public void actionOk() {
        addGlass(true);
    }

    public void actionNok() {
        addGlass(false);
    }


    public void actionBackDefect() {
        glassPanel.back();
    }
    public void actionBackGlass() {
        if(lastGlass!=null){
            glassRepository.deleteGlass(lastGlass);
            for (GlassDefect defect : lastGlass.getDefects()) {
                glassDefectRepository.delete(defect);
            }
            JOptionPane.showMessageDialog(glassControlView, "usunięto szybę model: " + lastGlass.getModel());
            lastGlass = null;
        }else{
            JOptionPane.showMessageDialog(glassControlView,"Nie usunięto szyby");
        }
    }

    public void actionMenu() {
            glassControlView.dispose();
            viewFactory.createWindowSelection();
    }

    public void typeModelAction() {
        glassControlView.unlockDefectSelection();
        glassControlView.unlockOkButtons();
        if (glassControlView.selectedDefect() != null) {
            actionDefectSelected();
        }
    }

    public void updateDefects(DefectCategory category) {
        glassControlView.setDefects(defectRepository.findDefectsByCategory(category));
    }
    public void actionDefectSelected() {
        glassPanel.setEnabled(true);
    }

    public void addGlass(boolean ok) {
        Deque<GlassDefectView> defectViews = glassPanel.getDefectViews();
        List<GlassDefect> defectsToSave = new ArrayList<>();
        for (GlassDefectView glassDefectView : defectViews) {
            GlassDefect glassDefect = new GlassDefect(glassDefectView.getDefect(), glassDefectView.getSection() );
            defectsToSave.add(glassDefect);
        }
        glassDefectRepository.addDefects(defectsToSave);
        Glass glass = new Glass(defectsToSave,glassControlView.getModelName(),glassControlView.getGlassType(), ok);
        glassRepository.addGlass(glass);
        glassControlView.resetView();
        lastGlass = glass;
    }
}
