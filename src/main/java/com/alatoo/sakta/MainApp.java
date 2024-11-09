package com.alatoo.sakta;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showLoginView();
    }

    // Display the login view
    private void showLoginView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/alatoo/sakta/login.fxml"));
            Parent root = loader.load();

            LoginController loginController = loader.getController();
            loginController.setMainApp(this);

            primaryStage.setTitle("Login");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void logout() {
        showLoginView();  // Return to login view
    }

    private UserController userController;
    private DoctorController doctorController;
    private NotificationService notificationService;

    public void showUserView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/alatoo/sakta/userPanel.fxml"));
            Parent root = loader.load();

            userController = loader.getController();
            userController.setMainApp(this);

            primaryStage.setTitle("User");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showDoctorView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/alatoo/sakta/doctorPanel.fxml"));
            Parent root = loader.load();

            doctorController = loader.getController();
            doctorController.initialize();
            doctorController.setMainApp(this);
            notificationService = new NotificationService(doctorController);

            primaryStage.setTitle("Doctor");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        launch(args);
    }
}