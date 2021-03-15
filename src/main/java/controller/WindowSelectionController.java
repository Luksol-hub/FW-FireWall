package controller;

import repository.DefectRepository;
import view.GlassControlView;
import view.WindowSelectionView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowSelectionController {
    private WindowSelectionView windowSelectionView;

    public WindowSelectionController(WindowSelectionView windowSelectionView) {
        this.windowSelectionView = windowSelectionView;
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
        GlassControlView view = new GlassControlView();
        GlassControlController glassControlController = new GlassControlController(view, new DefectRepository());

    }

    private void actionRoofLight() {
        GlassControlView view = new GlassControlView();
        GlassControlController glassControlController = new GlassControlController(view, new DefectRepository());
    }
}
