module com.alatoo.sakta {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.alatoo.sakta to javafx.fxml;
    exports com.alatoo.sakta;
}