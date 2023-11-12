package CSVReaders;

import Stations.Station;

import java.util.regex.Pattern;

public class StationFromCSV extends CSVReader {

    public StationFromCSV(String file) {
        readCSV(file);
    }

    Pattern pattern = Pattern.compile("^" + Pattern.quote("NL") + "$");

    @Override
    protected void GenerateFromLine(String line) {
        //0,1,4,7,8,9,10
        String[] lineSplit = line.split(",");
        if(pattern.matcher(lineSplit[7]).matches()) {
            Station.addStationToList(new Station(Short.parseShort(lineSplit[0]), lineSplit[1], lineSplit[4], lineSplit[7], lineSplit[8], Double.parseDouble(lineSplit[9]), Double.parseDouble(lineSplit[10])));
        }
    }
}