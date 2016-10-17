package com.travisbowen.hikinghelper;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GeoPointsObject {

    private String startTimeStamp;
    private Map<String, Location> locations = new HashMap<>();

    //Default constructor
    public GeoPointsObject() {

    }

    public GeoPointsObject(double latitude, double longitude) {
        locations.put(String.valueOf(Calendar.getInstance().getTime()), new Location(latitude, longitude));
        this.startTimeStamp = String.valueOf(Calendar.getInstance().getTime());
    }

    public String getStartTimeStamp() {
        return startTimeStamp;
    }

    public Map<String, Location> getLocations() {
        return locations;
    }

    static class Location {

        double latitude;
        double longitude;

        public Location() {
        }

        public Location(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }
}
