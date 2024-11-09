package com.alatoo.sakta;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class UserController {

    @FXML
    private Button shareLocationButton;

    private GeolocationService geolocationService;
    private NotificationService notificationService;
    private MainApp mainApp;

    public UserController() {
        geolocationService = new GeolocationService();
        notificationService = new NotificationService();
    }



    @FXML
    private void initialize() {
        shareLocationButton.setDisable(false);
    }

    @FXML
    private void onShareLocationPressed() {
        double[] userCoordinates = geolocationService.getCoordinates();
        double userLat = userCoordinates[0];
        double userLon = userCoordinates[1];

        notificationService.sendNotification(userLat, userLon);
        showAlert("Location Shared", "Your location has been shared with doctors.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleLogout() {
        mainApp.logout();  // Call the MainApp logout method
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


}
