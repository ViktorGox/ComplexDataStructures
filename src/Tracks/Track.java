package Tracks;

import CSVReaders.TrackFromCSV;

import java.util.ArrayList;

public class Track {
    private String stationCodeOne;
    private String stationCodeTwo;
    private short trackLengthOne;
    private short trackLengthTwo;
    private String trackType;

    private static final ArrayList<Track> tracks = new ArrayList<>();

    public Track(String stationCodeOne, String stationCodeTwo, short trackLengthOne, short trackLengthTwo, String trackType) {
        setStationCodeOne(stationCodeOne);
        setStationCodeTwo(stationCodeTwo);
        setTrackLengthOne(trackLengthOne);
        setTrackLengthTwo(trackLengthTwo);
        setTrackType(trackType);

        tracks.add(this);
    }

    private void setStationCodeOne(String stationCodeOne) {
        this.stationCodeOne = stationCodeOne;
    }

    private void setStationCodeTwo(String stationCodeTwo) {
        this.stationCodeTwo = stationCodeTwo;
    }

    private void setTrackLengthOne(short trackLengthOne) {
        this.trackLengthOne = trackLengthOne;
    }

    private void setTrackLengthTwo(short trackLengthTwo) {
        this.trackLengthTwo = trackLengthTwo;
    }

    private void setTrackType(String trackType) {
        this.trackType = trackType;
    }

    public static void GenerateTrackList() {
        new TrackFromCSV("resources/tracks.csv");
    }

    @Override
    public String toString() {
        return "Track{" +
                "stationCodeOne='" + stationCodeOne + '\'' +
                ", stationCodeTwo='" + stationCodeTwo + '\'' +
                ", trackLengthOne=" + trackLengthOne +
                ", trackLengthTwo=" + trackLengthTwo +
                ", trackType='" + trackType + '\'' +
                '}';
    }

    public static void TESTING_LIST_STATIONS() {
        for(Track t : tracks) {
            System.out.println(t);
        }
    }
}
