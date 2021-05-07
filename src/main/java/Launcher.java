import view.ViewFactory;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                ViewFactory viewFactory = new ViewFactory();
                viewFactory.createWindowSelection();
            }
        });


    }
}
