package Stations;

import CSVReaders.StationFromCSV;

import java.util.ArrayList;

public class Station {
    private short id;
    private String code;
    private String name;
    private String country;
    private String type;
    private double geoLat;
    private double geoLng;

    /** The list of countries, given by code, that are going to be saved in the city list. */
    private static String[] allowedCountriesCodes = new String[] {"NL"};
    private static ArrayList<Station> stations = new ArrayList<>();
    public Station(short id, String code, String name, String country, String type, double geoLat, double geoLng) {
        setId(id);
        setCode(code);
        setName(name);
        setCountry(country);
        setType(type);
        setGeoLat(geoLat);
        setGeoLng(geoLng);

        stations.add(this);
    }

    public void setId(short id) {
        this.id = id;
    }

    private void setCode(String code) {
        this.code = code;
    }

    private void setName(String name) {
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

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", geoLat=" + geoLat +
                ", geoLng=" + geoLng +
                "}";
    }

    public static void TESTING_LIST_STATIONS() {
        for(Station s : Station.stations) {
            System.out.println(s);
        }
    }
}