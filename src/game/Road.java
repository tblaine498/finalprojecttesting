package src.game;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Road {
    @FXML
    public Pane theRoad;


    Player player;

    @FXML
    public void initialize() {
        Player player = new Player(this, theRoad);
        //code for managing Player object here

        Creator entityCreator;
        int random = (int) (Math.random() * 10);
        if (random!=1) {
            entityCreator = new EnemyCreator();
        } else {
            entityCreator = new PowerupCreator();
        }

        Entity newEntity = entityCreator.createEntity();

        theRoad.setFocusTraversable(true);
    }


    @FXML
    public void onKeyPressed(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.RIGHT) {
            player.moveRight();
        } else if (keyEvent.getCode() == KeyCode.LEFT) {
            player.moveLeft();
        } else if (keyEvent.getCode() == KeyCode.R) {
            restart();
        }
    }

    public void restart() {

    }

    public void addNodeToRoad(Node node) {
        theRoad.getChildren().addAll(node);
    }
}
