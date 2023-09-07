package Stations;

public class Station {
    private short id;
    private String code;
    private String name;
    private String country;
    private String type;
    private double geoLat;
    private double geoLng;


    public void setId(short id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGeoLat(double geoLat) {
        this.geoLat = geoLat;
    }

    public void setGeoLng(double geoLng) {
        this.geoLng = geoLng;
    }
}
