package view;

import controller.GlassControlController;
import controller.WindowSelectionController;
import data.Defect;
import data.DefectCsvLoader;
import data.GlassType;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.DefectHibernateRepository;
import repository.DefectRepository;

import java.util.List;

public class ViewFactory {

//todo przerzucić do maina bazę danych

    public void createGlassControl(GlassType glassType) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        DefectRepository defectRepository = new DefectHibernateRepository(sessionFactory);
        DefectCsvLoader defectCsvLoader = new DefectCsvLoader();
        List<Defect> defects = defectCsvLoader.load();
        defectRepository.addDefects(defects);
        GlassView glassView = createGlassView(glassType);
        GlassControlView view = new GlassControlView(glassView);
        glassView.setMotherComponent(view);
        GlassControlController glassControlController = new GlassControlController(view, this, glassView, defectRepository);
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
