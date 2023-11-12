package src.game;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import javax.swing.text.IconView;

public class Player {
    private int lives = 3;
    private Point2D location;

    public Player(Road road, Pane roadPane) {
        ImageView imageView = new ImageView(new Image("BasicZombie.jpg"));
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        imageView.relocate(5, 5);
        road.addNodeToRoad(imageView);
    }


    public void move(KeyEvent keyEvent) {
        int directionDeterminer = 1;
        if (keyEvent.getCode() == KeyCode.LEFT) {
            directionDeterminer = -1;
        }
        //change location, but check bounds
    }
}
