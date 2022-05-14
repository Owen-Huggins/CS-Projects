//I worked on the homework assignment alone, using only course materials
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.FlowPane;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import javafx.scene.control.Alert;
import java.util.InputMismatchException;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
*This class represents an javafx application.
*@author Owen Huggins
*@version 1.0
*/

public class StarterUpper extends Application {
  /**
  *This main method of the application.
  *@param args a String array for the arguments for the main method.
  */
    public static void main(String[] args) {
        launch(args);
    }

    /**
    *This is the bulk of the application that adds everything to a scene.
    *@param mainStage the stage where all of the buttons and features are.
    */
    public void start(Stage mainStage) {
        int counter = 0;
        BorderPane pane  = new BorderPane();
        ArrayList<StartUpIdea> problemArray = new ArrayList<StartUpIdea>();
        ArrayList<Button> buttonArray = new ArrayList<Button>();
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(20, 0, 20, 0));
        flow.setVgap(20);
        flow.setHgap(20);
        flow.setPrefWrapLength(850);
        TextField problem = new TextField();
        problem.setPromptText("What is the problem?");
        String objProblem = problem.getText();
        problem.setPrefWidth(390);
        TextField targetCustomer = new TextField();
        targetCustomer.setPromptText("Who is the target customer?");
        targetCustomer.setPrefWidth(390);
        String objTargetCustomer = targetCustomer.getText();
        TextField customerNeed = new TextField();
        customerNeed.setPromptText("How badly does the customer NEED this problem to be fixed (1-10)?");
        customerNeed.setPrefWidth(390);
        TextField knownPeopleWithProblem = new TextField();
        knownPeopleWithProblem.setPromptText("How many people do you know who might experience this problem?");
        knownPeopleWithProblem.setPrefWidth(390);
        TextField targetMarketSize = new TextField();
        targetMarketSize.setPromptText("How big is the target market?");
        targetMarketSize.setPrefWidth(390);
        TextField competitors = new TextField();
        competitors.setPromptText("Who are the competitors/existing solutions?");
        String objCompetitors = competitors.getText();
        competitors.setPrefWidth(390);
        TextField name = new TextField();
        name.setPromptText("What is the name of your Project?");
        String objName = name.getText();
        name.setPrefWidth(390);
        TextField time = new TextField();
        time.setPromptText("How many hours will this take to complete?");
        time.setPrefWidth(390);
        TextField price = new TextField();
        price.setPromptText("How much will this cost to make(Whole dollars)?");
        price.setPrefWidth(390);
        TextField help = new TextField();
        help.setPromptText("How will this help people?");
        help.setPrefWidth(390);
        TextField money = new TextField();
        money.setPromptText("How will you make money from this?");
        money.setPrefWidth(390);
        TextField helpWithProject = new TextField();
        helpWithProject.setPromptText("Will you need help with this project(Y/N)?");
        helpWithProject.setPrefWidth(390);
        flow.getChildren().addAll(name, problem, targetCustomer, customerNeed, knownPeopleWithProblem, targetMarketSize,
            competitors, time, price, help, money, helpWithProject);
        HBox box = new HBox(15);
        box.setStyle("-fx-background-color: #336699;");
        box.setPadding(new Insets(15, 12, 15, 12));
        Button add = new Button("Add");
        HBox list = new HBox(15);
        list.setPadding(new Insets(15, 12, 15, 12));
        add.setOnAction(event -> {
                try {
                    if (problem.getText().trim().isEmpty() || targetCustomer.getText().trim().isEmpty()
                        || competitors.getText().trim().isEmpty()
                        || name.getText().trim().isEmpty() || help.getText().trim().isEmpty()
                        || money.getText().trim().isEmpty() || helpWithProject.getText().trim().isEmpty()) {
                        throw new NullPointerException();
                    }
                    problemArray.add(new StartUpIdea(problem.getText(), targetCustomer.getText()
                            , Integer.parseInt(customerNeed.getText())
                            , Integer.parseInt(knownPeopleWithProblem.getText())
                            , Integer.parseInt(targetMarketSize.getText()), competitors.getText()
                            , name.getText(), Integer.parseInt(time.getText()), Integer.parseInt(price.getText())
                            , help.getText(), money.getText(), helpWithProject.getText()));
                    boolean success = true;
                    Collections.sort(problemArray);
                    problem.clear();
                    targetCustomer.clear();
                    customerNeed.clear();
                    knownPeopleWithProblem.clear();
                    targetMarketSize.clear();
                    competitors.clear();
                    name.clear();
                    time.clear();
                    price.clear();
                    help.clear();
                    money.clear();
                    helpWithProject.clear();
                } catch (NullPointerException e) {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("You must enter a String into the String fields.");
                    a.show();
                } catch (NumberFormatException e) {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("You did not type an integer into an integer based text field.");
                    a.show();
                } catch (InputMismatchException e) {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("You must match the data types.");
                    a.show();
                }
            });
        add.setPrefSize(100, 20);
        Button sort = new Button("Sort");
        sort.setOnAction(event ->  {
                Collections.sort(problemArray);
            });
        sort.setPrefSize(100, 20);
        Button reset = new Button("Reset");
        reset.setOnAction(event -> {
                Alert a = new Alert(AlertType.CONFIRMATION);
                a.setContentText("Are you sure you wante to reset everything?");
                a.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {
                            problem.clear();
                            targetCustomer.clear();
                            customerNeed.clear();
                            knownPeopleWithProblem.clear();
                            targetMarketSize.clear();
                            competitors.clear();
                            name.clear();
                            time.clear();
                            price.clear();
                            problemArray.clear();
                            buttonArray.clear();
                            try {
                                Files.deleteIfExists(Paths.get("C:\\Users\\OwenS\\OneDrive\\Desktop\\Ideas.txt"));
                            } catch (IOException e) {
                                System.out.println("File not found");
                            }
                        }
                    });
            });
        reset.setPrefSize(100, 20);
        Button save = new Button("Save");
        save.setOnAction(event -> {
                String path = "C:\\Windows\\Media\\Ring06.wav";
                Media media = new Media(new File(path).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);
                FileUtil.saveIdeasToFile(problemArray, new File("C:\\Users\\OwenS\\OneDrive\\Desktop\\Ideas.txt"));
            });
        save.setPrefSize(100, 20);
        box.getChildren().addAll(add, sort, reset, save);
        mainStage.setTitle("Problem Ideation Form");
        pane.setTop(box);
        pane.setLeft(flow);
        pane.setBottom(list);
        Scene scene = new Scene(pane, 1200, 700);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
