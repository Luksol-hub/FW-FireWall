package view;

import controller.GlassControlController;
import controller.WindowSelectionController;
import defects.Defect;
import defects.DefectCsvLoader;
import defects.GlassType;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import defects.DefectHibernateRepository;
import defects.DefectRepository;

import java.util.List;

public class ViewFactory {

    private DefectRepository defectRepository;

    public ViewFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        defectRepository = new DefectHibernateRepository(sessionFactory);
    }

    //todo przerzucić do maina bazę danych. Wypełnia bazę danych tylko raz

    public void createGlassControl(GlassType glassType) {


        if(defectRepository.isEmpty()) {
            DefectCsvLoader defectCsvLoader = new DefectCsvLoader();
            List<Defect> defects = defectCsvLoader.load();
            defectRepository.addDefects(defects);
        }

        GlassPanel glassPanel = createGlassView(glassType);
        GlassControlView view = new GlassControlView(glassPanel);
        glassPanel.setMotherComponent(view);
        GlassControlController glassControlController = new GlassControlController(view, this, glassPanel, defectRepository);
    }


    private GlassPanel createGlassView(GlassType glassType) {
        switch (glassType) {
            case RL: return new GlassPanelRl();
            case WS: return new GlassPanelWs();
            default: throw new IllegalStateException("Nie udało się dopasować kształtu szyby");
        }
    }

    public void createWindowSelection() {
        WindowSelectionView windowSelectionView = new WindowSelectionView();
        WindowSelectionController windowSelectionController = new WindowSelectionController(windowSelectionView, this);

    }
}
