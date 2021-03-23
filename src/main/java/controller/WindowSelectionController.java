package controller;

import data.GlassType;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowSelectionController {
    private WindowSelectionView windowSelectionView;
    private ViewFactory viewFactory;


    public WindowSelectionController(WindowSelectionView windowSelectionView, ViewFactory viewFactory) {
        this.windowSelectionView = windowSelectionView;
        this.viewFactory = viewFactory;
        addActions();
    }
    private void addActions() {
        ActionListener actionListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actionWindScreen();
            }
        };

        ActionListener actionListener2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actionRoofLight();
            }
        };

        windowSelectionView.addActionWindScreen(actionListener);
        windowSelectionView.addActionRooflight(actionListener2);
    }

    private void actionWindScreen() {
        viewFactory.createGlassControl(GlassType.WS);
        windowSelectionView.dispose();


    }

    private void actionRoofLight() {
        viewFactory.createGlassControl(GlassType.RL);
        windowSelectionView.dispose();


    }
}
