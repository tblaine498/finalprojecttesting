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


    private ImageView imageView;

    private static final int HEIGHT = 200;
    private static final int WIDTH = 200;
    private Road road;

    public Player(Road road, Pane roadPane) {
        this.road = road;
//        imageView = new ImageView(new Image("@../../src/objectImages/RandomLazerShooter.jpg"));       //why like this?
        imageView = new ImageView(new Image("@../../src/objectImages/car.png"));
        imageView.setFitHeight(HEIGHT);
        imageView.setFitWidth(WIDTH);

        location = new Point2D(roadPane.getPrefWidth()/2, roadPane.getPrefHeight()-100);
        imageView.relocate(roadPane.getPrefWidth()/2, roadPane.getPrefHeight()-100);
        road.addNodeToRoad(imageView);
    }

    public void moveLeft() {
        if(location.getX() > WIDTH/6){
            location = new Point2D(location.getX() - 10, location.getY());
            setPosition();
        }
    }

    public void moveRight() {
        if(location.getX() < (road.theRoad.getWidth()- WIDTH/6)) {
            location = new Point2D(location.getX() + 10, location.getY());
            setPosition();
        }
    }

    private void setPosition() {
        double iconX = location.getX() - imageView.boundsInParentProperty().get().getWidth()/2;
        double iconY = location.getY() - imageView.boundsInParentProperty().get().getHeight()/2;
        imageView.relocate(iconX, iconY);
    }
}
