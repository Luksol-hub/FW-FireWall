package controller;

import data.DefectCategory;
import data.DefectCsvLoader;
import repository.DefectRepository;
import view.GlassControlView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlassControlController {
    private GlassControlView glassControlView;
    private DefectRepository defectRepository;


    public GlassControlController(GlassControlView glassControlView, DefectRepository defectRepository) {
        this.glassControlView = glassControlView;
        this.defectRepository = defectRepository;
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
        glassControlView.addActionOk(actionListener);
        glassControlView.addActionNok(actionListener2);
        glassControlView.addActionRepair(actionListener3);
        glassControlView.addActionBack(actionListener4);
        glassControlView.addActionSelection(actionListener5);
    }

    public void actionOk() {
        System.out.println("OK");
    }

    public void actionNok() { System.out.println("NOK");}

    public void actionRepair() { System.out.println("Przeróbka");}

    public void actionBack() { System.out.println("Cofnij");

            glassControlView.setVisible(false);

    }

    public void updateDefects(DefectCategory category) {
        glassControlView.setDefects(defectRepository.findDefectsByCategory(category));
    }
}
