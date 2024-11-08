package com.alatoo.sakta;
import java.util.ArrayList;
import java.util.List;

class User {
    private double latitude;
    private double longitude;
    private String name;

    public User(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }
}
class Doctor extends User {
    private boolean isAvailable;

    public Doctor(String name, double latitude, double longitude, boolean isAvailable) {
        super(name, latitude, longitude);
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void respondToHelpRequest(User user) {
        System.out.println("Доктор " + getName() + " направляется к пользователю " + user.getName() +
                " по координатам: " + user.getLatitude() + ", " + user.getLongitude());
        this.isAvailable = false;
    }
}