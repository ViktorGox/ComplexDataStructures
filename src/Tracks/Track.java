package Tracks;

import CSVReaders.TrackFromCSV;
import Sorting.InsertionSort;
import Sorting.QuickSort;

import java.util.ArrayList;

public class Track implements Comparable<Track> {
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
    }

    private void setStationCodeOne(String stationCodeOne) {
        this.stationCodeOne = stationCodeOne.toUpperCase();
    }

    private void setStationCodeTwo(String stationCodeTwo) {
        this.stationCodeTwo = stationCodeTwo.toUpperCase();
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

    public static void addTrackToList(Track track) {
        tracks.add(track);
    }

    public static Track[] getTracks() {
        Track[] array = new Track[tracks.size()];
        return tracks.toArray(array);
    }

    public String getStationCodeOne() {
        return stationCodeOne;
    }

    public String getStationCodeTwo() {
        return stationCodeTwo;
    }

    public short getTrackLengthOne() {
        return trackLengthOne;
    }

    public static void GenerateTrackList() {
        new TrackFromCSV("resources/tracks.csv");
    }

    @Override
    public String toString() {
        return "Track{" +
                "stationCodeOne=" + stationCodeOne + ' ' +
                ", stationCodeTwo=" + stationCodeTwo + ' ' +
                ", trackLengthOne=" + trackLengthOne +
                ", trackLengthTwo=" + trackLengthTwo +
                ", trackType=" + trackType + ' ' +
                '}';
    }

    public static Track[] sortInsertion() {
        Track[] tracksArray = new Track[tracks.size()];
        tracks.toArray(tracksArray);
        InsertionSort<Track> tracks = new InsertionSort<>();
        tracks.sort(tracksArray);
        return tracksArray;
    }

    public static Track[] sortQuick() {
        Track[] tracksArray = new Track[tracks.size()];
        tracks.toArray(tracksArray);
        QuickSort<Track> tracks = new QuickSort<>();
        tracks.sort(tracksArray);
        return tracksArray;
    }

    @Override
    public int compareTo(Track o) {
        return Short.compare(trackLengthOne, o.trackLengthOne);
    }
}