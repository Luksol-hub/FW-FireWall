import controller.WindowSelectionController;
import data.DefectCategory;
import data.DefectCsvLoader;
import view.ViewFactory;
import view.WindowSelectionView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.createWindowSelection();

    }
}
