package src.game;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Road {
    @FXML
    public Pane road;

    Player player;



    public void run() {
        Player player = new Player(this, road);
        //code for managing Player object here

        Creator entityCreator;
        int random = (int) (Math.random() * 10);
        if (random!=1) {
            entityCreator = new EnemyCreator();
        } else {
            entityCreator = new PowerupCreator();
        }

        Entity newEntity = entityCreator.createEntity();

        //code for exploring interaction between Entity and Player here


    }


    @FXML
    public void onKeyPress(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.LEFT) {
            player.move(keyEvent);
        } else if (keyEvent.getCode() == KeyCode.R) {
            restart();
        }
    }

    public void restart() {

    }

    public void addNodeToRoad(Node node) {

    }
}
