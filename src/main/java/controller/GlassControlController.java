package controller;

import data.DefectCategory;
import repository.DefectRepository;
import view.GlassControlView;
import view.GlassView;
import view.ViewFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GlassControlController {
    private GlassControlView glassControlView;
    private ViewFactory viewFactory;
    private GlassView glassView; // todo poprawić nazwy
    private DefectRepository defectRepository;


    public GlassControlController(GlassControlView glassControlView, ViewFactory viewFactory, GlassView glassView, DefectRepository defectRepository) {
        this.glassControlView = glassControlView;
        this.viewFactory = viewFactory;
        this.glassView = glassView;
        this.defectRepository = defectRepository;
        this.glassControlView.lockDefectSelection();
        glassView.setEnabled(false); // todo ma się to wykonać dynamicznie
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
                actionRepair();
            }
        };
        ActionListener actionListener4 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actionBack();
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

        glassControlView.addActionOk(actionListener);
        glassControlView.addActionNok(actionListener2);
        glassControlView.addActionRepair(actionListener3);
        glassControlView.addActionBack(actionListener4);
        glassControlView.addActionSelection(actionListener5);
        glassControlView.addTypeModelAction(keyListener);
    }

    public void actionOk() {
        System.out.println("OK");
    }

    public void actionNok() { System.out.println("NOK");}

    public void actionRepair() { System.out.println("Przeróbka");}

    public void actionBack() {
            glassControlView.dispose();
            viewFactory.createWindowSelection();
    }

    public void typeModelAction() {
        glassControlView.unlockDefectSelection();
    }
    public void updateDefects(DefectCategory category) {
        glassControlView.setDefects(defectRepository.findDefectsByCategory(category));
//        glassControlView.setDefects(defectRepository.getDefects());
    }

}
