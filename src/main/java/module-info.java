module com.mycompany.cgpaproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.cgpaproject to javafx.fxml;
    exports com.mycompany.cgpaproject;
}
