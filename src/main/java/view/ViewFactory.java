package view;

import controller.GlassControlController;
import controller.WindowSelectionController;
import data.GlassType;
import repository.DefectRepository;

public class ViewFactory {



    public void createGlassControl(GlassType glassType) {
        GlassView glassView = createGlassView(glassType);
        GlassControlView view = new GlassControlView(glassView);
        GlassControlController glassControlController = new GlassControlController(view, new DefectRepository(), this, glassView);
    }

    private GlassView createGlassView(GlassType glassType) {
        switch (glassType) {
            case RL: return new GlassViewRl();
            case WS: return new GlassViewWs();
            default: throw new IllegalStateException("Nie udało się dopasować kształtu szyby");
        }
    }

    public void createWindowSelection() {
        WindowSelectionView windowSelectionView = new WindowSelectionView();
        WindowSelectionController windowSelectionController = new WindowSelectionController(windowSelectionView, this);

    }
}
