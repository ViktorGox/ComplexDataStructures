package CSVReaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class CSVReader {
    public void readCSV(String file) {
        try {
            File stationsFile = new File(file);
            Scanner scannerCSVReader = new Scanner(stationsFile);

            //Skip first line.
            scannerCSVReader.nextLine();

            while (scannerCSVReader.hasNextLine()) {
                String line = scannerCSVReader.nextLine();
                GenerateFromLine(line);
            }
            scannerCSVReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    protected abstract void GenerateFromLine(String line);
}
