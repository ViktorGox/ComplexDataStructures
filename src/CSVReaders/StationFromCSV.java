package CSVReaders;

import Exceptions.CountryNotSupported;
import Stations.Station;

public class StationFromCSV extends CSVReader {

    public StationFromCSV(String file) {
        readCSV(file);
    }

    @Override
    protected void GenerateFromLine(String line) {
        //0,1,4,7,8,9,10
        String[] lineSplit = line.split(",");
        try {
            Station.addStationToList(new Station(Short.parseShort(lineSplit[0]), lineSplit[1], lineSplit[4], lineSplit[7], lineSplit[8], Double.parseDouble(lineSplit[9]), Double.parseDouble(lineSplit[10])));
        } catch (CountryNotSupported ignored) {
        }
    }
}