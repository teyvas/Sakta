module com.alatoo.sakta {
    requires javafx.fxml;
    requires java.sql;
    requires org.json;
    requires javafx.web;

    opens com.alatoo.sakta to javafx.fxml;
    exports com.alatoo.sakta;
}