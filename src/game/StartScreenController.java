package src.game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartScreenController {
    @FXML
    public Button startButton;

    public void setStage(Stage startStage, Stage roadStage, Road road) {
        startButton.setOnAction(obs -> {
            startStage.close();
            roadStage.show();
            road.startCreatingEntities();
        });
    }
}
