package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefectCsvLoader {
    public List<Defect> load() {
        List<Defect> allDefects = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(getClass().getResource("/defects.csv").toURI()));

            while(sc.hasNextLine()) {
                String defectsCsvLine = sc.nextLine();
                String[] defectsCsvArray = defectsCsvLine.split(",");
                int defectCategoryNumber = Integer.parseInt(defectsCsvArray[0]);
                String defectName = defectsCsvArray[1];
                Defect windowDefect = new Defect(defectName, DefectCategory.values()[defectCategoryNumber - 1]);
                allDefects.add(windowDefect);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return allDefects;
    }

}
