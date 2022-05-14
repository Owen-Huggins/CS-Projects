package cs2340.gamescreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class StartController {
    @FXML
    private Label welcomeText;

    @FXML
    private javafx.scene.control.Button closeButton;


    @FXML
    protected void onHelloButtonClick(ActionEvent e) throws IOException {

        FXMLLoader root = new FXMLLoader(StartScreen.class.getResource("config-view.fxml"));
        Scene scene = new Scene(root.load(), 1200, 800);
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.setTitle("Configuration Screen");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    protected void onCloseButtonClick(ActionEvent e) {
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
