package CSVReaders;

import Stations.Station;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StationFromCSV extends CSVReader {

    public StationFromCSV(String file) {
        readCSV(file);
    }

    Pattern patternCountry = Pattern.compile("^" + Pattern.quote("NL") + "$");
    Pattern patternApStart = Pattern.compile("^'");


    @Override
    protected void GenerateFromLine(String line) {
        //0,1,4,7,8,9,10
        String[] lineSplit = line.split(",");
        if (!patternCountry.matcher(lineSplit[7]).matches()) {
            return;
        }

        Matcher matcher = patternApStart.matcher(lineSplit[4]);

        if (matcher.find()) {
            StringBuilder sb = new StringBuilder(lineSplit[4]);
            sb.deleteCharAt(0);
            lineSplit[4] = sb.toString();
        }

        Station.addStationToList(new Station(Short.parseShort(lineSplit[0]), lineSplit[1], lineSplit[4], lineSplit[7], lineSplit[8], Double.parseDouble(lineSplit[9]), Double.parseDouble(lineSplit[10])));
    }
}