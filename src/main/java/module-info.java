module com.example.reservasfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.reservasfx to javafx.fxml;
    exports com.example.reservasfx;
}