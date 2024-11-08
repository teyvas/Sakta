package com.alatoo.sakta;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MapController {
    @FXML
    private Pane mapPane;
    @FXML
    private Canvas mapCanvas;
    @FXML
    private TextField userNameField;
    @FXML
    private TextField userLatitudeField;
    @FXML
    private TextField userLongitudeField;

    private List<User> users = new ArrayList<>();
    private MapService mapService = new MapService();
    private GraphicsContext gc;

    @FXML
    public void initialize() {
        gc = mapCanvas.getGraphicsContext2D();
        drawMap();
    }

    private void drawMap() {
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, mapCanvas.getWidth(), mapCanvas.getHeight());
    }

    public void addUser() {
        try {
            String name = userNameField.getText();
            double latitude = Double.parseDouble(userLatitudeField.getText());
            double longitude = Double.parseDouble(userLongitudeField.getText());

            User user = new User(name, latitude, longitude);
            users.add(user);
            drawUserOnMap(user);

            showInfoAlert("User Added", "User " + name + " added at coordinates (" + latitude + ", " + longitude + ").");
        } catch (NumberFormatException e) {
            showErrorAlert("Invalid Input", "Please enter valid coordinates.");
        }
    }

    public void requestHelp() {
        if (users.isEmpty()) {
            showErrorAlert("No Users", "Please add a user first.");
            return;
        }

        User user = users.get(0); // Возьмем первого пользователя для простоты примера
        Doctor doctor = mapService.findNearestAvailableDoctor(user);

        if (doctor != null) {
            mapService.requestHelp(user);
            drawDoctorOnMap(doctor);
            showInfoAlert("Help Sent", "Doctor " + doctor.getName() + " is heading to " + user.getName());
        } else {
            showErrorAlert("No Available Doctors", "No available doctors nearby.");
        }
    }

    private void drawUserOnMap(User user) {
        double[] coordinates = convertCoordinatesToMap(user.getLatitude(), user.getLongitude());
        gc.setFill(Color.BLUE);
        gc.fillOval(coordinates[0], coordinates[1], 10, 10);
    }

    private void drawDoctorOnMap(Doctor doctor) {
        double[] coordinates = convertCoordinatesToMap(doctor.getLatitude(), doctor.getLongitude());
        gc.setFill(Color.RED);
        gc.fillOval(coordinates[0], coordinates[1], 10, 10);
    }

    private double[] convertCoordinatesToMap(double latitude, double longitude) {
        // Преобразование широты/долготы в координаты карты (условно, для примера)
        double x = (longitude + 180) * (mapCanvas.getWidth() / 360);
        double y = (90 - latitude) * (mapCanvas.getHeight() / 180);
        return new double[] { x, y };
    }

    private void showInfoAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
