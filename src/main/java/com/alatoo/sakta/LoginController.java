package com.alatoo.sakta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

// Validate username and password with MyJDBC
        if (MyJDBC.validateUser(username, password)) {
            // If validation is successful, show the appropriate view based on the username
            if ("user".equalsIgnoreCase(username)) {
                mainApp.showUserView();
            } else if ("doctor".equalsIgnoreCase(username)) {
                mainApp.showDoctorView();
            } else {
                showAlert("User Error", "Invalid username. Please enter 'user' or 'doctor'.");
            }
        } else {
            // Show an error if validation fails
            showAlert("Login Error", "Invalid username or password!");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}