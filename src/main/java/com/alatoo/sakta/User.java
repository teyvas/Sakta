package com.alatoo.sakta;


public class User {
    private String username;
    private String role;
    private double latitude;
    private double longitude;

    public User( String username, String role,  double latitude, double longitude) {
        this.username = username;
        this.role = role;

        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and setters

    public String getUsername() { return username; }
    public String getRole() { return role; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    private String notificationToken; // Add this attribute



    public String getNotificationToken() {
        return notificationToken;
    }

}
