module com.example.joshuaburt_comp1011sec005_labex05 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.joshuaburt_comp1011sec005_labex05 to javafx.fxml;
    exports com.example.joshuaburt_comp1011sec005_labex05;
}