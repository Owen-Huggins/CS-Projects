package cs2340.gamescreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreen extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root1 = new FXMLLoader(StartScreen.class.getResource("start-view.fxml"));
        Scene scene = new Scene(root1.load(), 1200, 800);
        stage.setTitle("Starting Screen");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}