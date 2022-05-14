module cs2340.gamescreen {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens cs2340.gamescreen to javafx.fxml;
    exports cs2340.gamescreen;
}