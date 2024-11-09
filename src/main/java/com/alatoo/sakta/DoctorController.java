package com.alatoo.sakta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class DoctorController {

    public Button logoutButton;
    @FXML
    private WebView mapWebView;
    private WebEngine webEngine;
    private Button LogoutButton;
    private double doctorLat = 42.8746;
    private double doctorLon = 74.6126;
    private double userLat = 42.8403;
    private double userLon = 74.6190;
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void initialize() {
        if (mapWebView != null) {
            webEngine = mapWebView.getEngine();
            loadMap();
        } else {
            System.out.println("WebView not initialized properly.");
        }
    }

    @FXML
    private void handleLogout() {
        if (mainApp != null) {
            mainApp.logout();  // Call the MainApp logout method
        } else {
            System.out.println("MainApp is not initialized.");
        }
    }

    // Load the map with initial doctor and user markers
    private void loadMap() {
        String mapHtml = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>Doctor Map</title>"
                + "<meta charset='utf-8' />"
                + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
                + "<link rel='stylesheet' href='https://unpkg.com/leaflet@1.7.1/dist/leaflet.css' />"
                + "<script src='https://unpkg.com/leaflet@1.7.1/dist/leaflet.js'></script>"
                + "<script>"
                + "var map, doctorMarker, userMarker;"
                + "function initMap(doctorLat, doctorLon, userLat, userLon) {"
                + "    map = L.map('map').setView([doctorLat, doctorLon], 13);"
                + "    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {"
                + "        attribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors'"
                + "    }).addTo(map);"
                + "    doctorMarker = L.marker([doctorLat, doctorLon]).addTo(map).bindPopup('Doctor Location');"
                + "    userMarker = L.marker([userLat, userLon]).addTo(map).bindPopup('User Location');"
                + "}"
                + "function updateUserLocation(userLat, userLon) {"
                + "    if (userMarker) {"
                + "        map.removeLayer(userMarker);"
                + "    }"
                + "    userMarker = L.marker([userLat, userLon]).addTo(map).bindPopup('Updated User Location').openPopup();"
                + "}"
                + "</script>"
                + "</head>"
                + "<body onload='initMap(" + doctorLat + ", " + doctorLon + ", " + userLat + ", " + userLon + ")'>"
                + "<div id='map' style='height: 100vh; width: 100%;'></div>"
                + "</body>"
                + "</html>";

        webEngine.loadContent(mapHtml);
    }

    // Method to dynamically update user coordinates
    public void updateMapWithCoordinates(double newUserLat, double newUserLon) {
        this.userLat = newUserLat;
        this.userLon = newUserLon;
        String jsCode = "updateUserLocation(" + newUserLat + ", " + newUserLon + ");";
        webEngine.executeScript(jsCode);
    }


}
