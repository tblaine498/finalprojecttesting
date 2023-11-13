package src.game;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import javax.swing.text.IconView;
import java.io.File;

public class Player {
    private int lives = 3;
    private Point2D location;

    private Pane roadPane;

    private ImageView imageView;

    public Player(Road road, Pane roadPane) {
        this.roadPane = roadPane;
        imageView = new ImageView(new Image("@../../src/objectImages/RandomLazerShooter.jpg"));       //why like this?
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);

        location = new Point2D(roadPane.getPrefWidth()/2, roadPane.getPrefHeight()-100);
        imageView.relocate(roadPane.getPrefWidth()/2, roadPane.getPrefHeight()-100);
        road.addNodeToRoad(imageView);
    }

    public void moveLeft() {
        if (!(location.getX() <= 10)) {
            location.add(new Point2D(5, 0));
            setPosition();
        }
    }

    public void moveRight() {
        if (!(location.getX() >= roadPane.getPrefWidth()-100)) {
            location.add(new Point2D(5, 0));
            setPosition();
        }
        //change location, but check bounds
    }

    private void setPosition() {
        double iconX = location.getX() - imageView.boundsInParentProperty().get().getWidth()/2;
        double iconY = location.getY() - imageView.boundsInParentProperty().get().getHeight()/2;
        imageView.relocate(iconX, iconY);
    }
}
