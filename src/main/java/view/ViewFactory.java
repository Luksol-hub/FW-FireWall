package view;

import controller.GlassControlController;
import controller.WindowSelectionController;
import repository.DefectRepository;

public class ViewFactory {

    public void createGlassControl() {
        GlassControlView view = new GlassControlView();
        GlassControlController glassControlController = new GlassControlController(view, new DefectRepository());
    }
    public void createWindowSelection() {
        WindowSelectionView windowSelectionView = new WindowSelectionView();
        WindowSelectionController windowSelectionController = new WindowSelectionController(windowSelectionView);

    }
}
