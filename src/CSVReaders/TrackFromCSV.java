package CSVReaders;

import Tracks.Track;

public class TrackFromCSV extends CSVReader{
    public TrackFromCSV(String file) {
        readCSV(file);
    }
    @Override
    protected void GenerateFromLine(String line) {
        String[] lineSplit = line.split(",");
        Track.addTrackToList(new Track(lineSplit[0],lineSplit[1],Short.parseShort(lineSplit[2]),Short.parseShort(lineSplit[3]),lineSplit[4]));
    }
}
