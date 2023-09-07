package Stations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StationFromCSV {
    protected StationFromCSV(String file) {
        try {
            File stationsFile = new File(file);
            Scanner scannerCSVReader = new Scanner(stationsFile);

            //Skip first line.
            scannerCSVReader.nextLine();

            while (scannerCSVReader.hasNextLine()) {
                String line = scannerCSVReader.nextLine();
                GenerateStationFromLine(line);
            }
            scannerCSVReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void GenerateStationFromLine(String line) {
        //0,1,4,7,8,9,10
        String[] lineSplit = line.split(",");
        new Station(Short.parseShort(lineSplit[0]),lineSplit[1],lineSplit[4],lineSplit[7],lineSplit[8],Double.parseDouble(lineSplit[9]),Double.parseDouble(lineSplit[10]));
    }
}