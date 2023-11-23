package src.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader startLoader = new FXMLLoader();
        startLoader.setLocation(getClass().getResource("start-screen.fxml"));
        Parent startContainer = startLoader.load();
        stage.setTitle("Start Menu");
        stage.setScene(new Scene(startContainer));
        stage.setResizable(false);
        stage.show();

        Stage roadStage = new Stage();
        FXMLLoader roadLoader = new FXMLLoader();
        roadLoader.setLocation(getClass().getResource("game-road.fxml"));
        Parent roadContainer = roadLoader.load();
        roadStage.setTitle("Zombie Apocalypse 1");
        roadStage.setScene(new Scene(roadContainer));
        roadStage.setResizable(false);

        StartScreenController startScreenController = startLoader.getController();
        startScreenController.setStage(stage, roadStage, roadLoader.getController());
    }


}
