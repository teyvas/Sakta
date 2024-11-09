package com.alatoo.sakta;

public class Doctor {
    private String username;
    private double latitude;
    private double longitude;
    public Doctor( double latitude, double longitude) {

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
