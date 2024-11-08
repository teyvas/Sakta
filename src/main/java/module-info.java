module com.alatoo.sakta {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alatoo.sakta to javafx.fxml;
    exports com.alatoo.sakta;
}