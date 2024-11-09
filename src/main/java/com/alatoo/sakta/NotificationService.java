package com.alatoo.sakta;

public class NotificationService {

    private DoctorController doctorController;

    // Pass DoctorController to allow dynamic updates
    public NotificationService(DoctorController doctorController) {
        this.doctorController = doctorController;
    }

    public NotificationService() {

    }

    public void sendNotification(double lat, double lon) {
        System.out.println("Notifying doctors of user's location at: (" + lat + ", " + lon + ")");
        doctorController.updateMapWithCoordinates(lat, lon);  // Update map in DoctorController
    }
}
