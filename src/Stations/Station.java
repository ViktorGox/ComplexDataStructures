package Stations;

import CSVReaders.StationFromCSV;
import Exceptions.CountryNotSupported;
import MyCollections.Graph.Graph;
import Tracks.Track;
import Utilities.StringModification;

import java.util.ArrayList;
import java.util.Arrays;

public class Station {
    private short id;
    private String code;
    private String name;
    private String country;
    private String type;
    private double geoLat;
    private double geoLng;

    /**
     * The list of countries, given by code, that are going to be saved in the city list.
     */
    private static final String[] allowedCountriesCodes = new String[]{"NL"};
    private static final ArrayList<Station> stations = new ArrayList<>();

    public Station(short id, String code, String name, String country, String type, double geoLat, double geoLng) throws CountryNotSupported {
        for (String allowedCountriesCode : allowedCountriesCodes) {
            if(country.equals(allowedCountriesCode)) continue;
            throw new CountryNotSupported("The country from the code " + country + " is not supported. Supported codes are " + Arrays.toString(allowedCountriesCodes));
        }


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
        stations.add(station);
    }

    public static Station[] getStations() {
        Station[] array = new Station[stations.size()];
        return stations.toArray(array);
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
        Station.GenerateStationList();
        Track.GenerateTrackList();

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
}