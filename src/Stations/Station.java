package Stations;

import CSVReaders.StationFromCSV;
import MyCollections.Graph.Graph;
import MyCollections.HashTable.HashMap;
import MyCollections.LinkedList.LinkedList;
import MyCollections.Tree.AVLTree;
import Sorting.QuickSort;
import Tracks.Track;
import Utilities.StringModification;

import java.util.Arrays;

public class Station implements Comparable<Station> {
    private short id;
    private String code;
    private String name;
    private String country;
    private String type;
    private double geoLat;
    private double geoLng;
    private static final LinkedList<Station> stationsLinkedList = new LinkedList<>();
    private static final AVLTree<Station> stationsAVLTree = new AVLTree<>();
    private static final HashMap<String, Station> stationsHashMap = new HashMap<>();

    public Station(short id, String code, String name, String country, String type, double geoLat, double geoLng) {
        setId(id);
        setCode(code);
        setName(name);
        setCountry(country);
        setType(type);
        setGeoLat(geoLat);
        setGeoLng(geoLng);
    }

    public void setId(short id) {
        this.id = id;
    }

    private void setCode(String code) {
        if (code == null) throw new IllegalArgumentException("Station code must not be null!");
        if (code.isBlank()) throw new IllegalArgumentException("Station code must not be empty! " + code);
        this.code = code;
    }

    private void setName(String name) {
        name = StringModification.removeQuotes(name);
        this.name = name;
    }

    private void setCountry(String country) {
        this.country = country;
    }

    private void setType(String type) {
        this.type = type;
    }

    private void setGeoLat(double geoLat) {
        this.geoLat = geoLat;
    }

    private void setGeoLng(double geoLng) {
        this.geoLng = geoLng;
    }

    public static void GenerateStationList() {
        new StationFromCSV("resources/stations.csv");
    }

    public static void addStationToList(Station station) {
        stationsLinkedList.add(station);
        stationsAVLTree.add(station);
        stationsHashMap.put(station.code, station);
    }

    public static Station[] getStations() {
        return stationsLinkedList.convertToArray(new Station[stationsLinkedList.size()]);
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", code=" + code + ' ' +
                ", name=" + name + ' ' +
                ", country=" + country + ' ' +
                ", type=" + type + ' ' +
                ", geoLat=" + geoLat +
                ", geoLng=" + geoLng +
                "}";
    }

    public static Graph<String> generateStationGraph() {
        Graph<String> stationGraph = new Graph<>();
        Station[] stations = Station.getStations();
        Track[] tracks = Track.getTracks();
        for (Station station : stations) {
            stationGraph.addNode(station.getCode());
        }

        for (Track track : tracks) {
            stationGraph.connectOneWay(track.getStationCodeOne(), track.getStationCodeTwo(), track.getTrackLengthOne());
        }

        return stationGraph;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Station)) return false;
        if (this == obj) return true;
        if (this.name.equals(((Station) obj).name)) return true;
        return false;
    }

    public static Double calculateDistanceBetween(String one, String two) {
        Station stationOne = stationsHashMap.get(one);
        Station stationTwo = stationsHashMap.get(two);

        double longitude = Math.abs(stationOne.geoLng - stationTwo.geoLng);
        double latitude = Math.abs(stationOne.geoLat - stationTwo.geoLat);

        double result = Math.pow(longitude, 2) + Math.pow(latitude, 2);
        return Math.sqrt(result);
    }

    public static Station getStationByCode(String code) {
        return stationsHashMap.get(code);
    }

    @Override
    public int compareTo(Station o) {
        int nameResult = name.compareTo(o.name);
        if (nameResult < 0) {
            return -1;
        } else if (nameResult > 0) {
            return 1;
        } else {
            return Short.compare(id, o.id);
        }
    }

    public static double getGeoLat(String code) {
        return getStationByCode(code).getGeoLat();
    }

    public static double getGeoLng(String code) {
        return getStationByCode(code).getGeoLng();
    }

    public double getGeoLat() {
        return geoLat;
    }

    public double getGeoLng() {
        return geoLng;
    }

    public static Station searchForStationBinarySearch(String name) {
        Station[] stationArray = new Station[stationsLinkedList.size()];
        stationsLinkedList.convertToArray(stationArray);
        QuickSort<Station> quickSort = new QuickSort<>();
        quickSort.sort(stationArray);
        return binarySearch(stationArray, name);
    }

    private static Station binarySearch(Station[] sortedStationArray, String name) {
        int low = 0;
        int high = sortedStationArray.length - 1;

        while (high >= low) {
            int middle = low + (high - low) / 2;

            int compareResult = sortedStationArray[middle].name.compareTo(name);

            if (compareResult == 0) {
                return sortedStationArray[middle];
            } else if (compareResult < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return null;
    }

    public static Station getStationLinear(String name) {
        Station[] stationArray = new Station[stationsLinkedList.size()];
        stationsLinkedList.convertToArray(stationArray);
        for (Station station : stationArray) {
            if (station.name.equals(name)) {
                return station;
            }
        }
        return null;
    }
}
