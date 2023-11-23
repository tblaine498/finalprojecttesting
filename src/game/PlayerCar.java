package src.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class PlayerCar {
    private static final int HEIGHT = 200;
    private static final int WIDTH = 200;
    private final HBox hbox = new HBox();
    private Point2D location;
    private int lives = 3;
    private ImageView imageView;
    private Road road;

    private List<ImageView> bulletsList = new ArrayList<>();

    public PlayerCar(Road road, Pane roadPane) {
        this.road = road;
        imageView = new ImageView(new Image("@../../src/objectImages/car.png"));
        imageView.setFitHeight(HEIGHT);
        imageView.setFitWidth(WIDTH);

        hbox.getChildren().addAll(new ImageView("@../../src/objectImages/heart.png"),
                new ImageView("@../../src/objectImages/heart.png"),
                new ImageView("@../../src/objectImages/heart.png"));
        hbox.setAlignment(Pos.BASELINE_RIGHT);

        location = new Point2D(roadPane.getPrefWidth()/2, roadPane.getPrefHeight() - 100);
        setPosition();

        road.addNodeToRoad(imageView);
        hbox.setLayoutX(75);
        hbox.setLayoutY(7);
        road.addNodeToRoad(hbox);
    }

    public void hit(){
        if (lives > 0){
            hbox.getChildren().remove(--lives);
        }
    }

    private void setPosition() {
        double iconX = location.getX() - imageView.boundsInParentProperty().get().getWidth()/2;
        double iconY = location.getY() - imageView.boundsInParentProperty().get().getHeight()/2;
        imageView.relocate(iconX, iconY);
    }

    public void move(MouseEvent mouseEvent){
        if(mouseEvent.getX() < road.theRoad.getWidth()- WIDTH/12){
            location = new Point2D(mouseEvent.getX(), location.getY());
            setPosition();
        }
    }

    public void shoot() {
        ImageView bullet = new ImageView(new Image("@../../src/objectImages/bullet.png"));
        bulletsList.add(bullet);
        bullet.setX(location.getX());
        bullet.setY(location.getY() - 80);
        road.addNodeToRoad(bullet);

        double bulletSpeed = 5.0;
        Timeline timeline = getTimeline(bullet, bulletSpeed);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    public List<ImageView> getBulletsList() {
        return bulletsList;
    }

    private Timeline getTimeline(ImageView bullet, double bulletSpeed) {
        Duration duration = Duration.millis(16.7);

        return new Timeline(new KeyFrame(duration, event -> {
            bullet.setY(bullet.getY() - bulletSpeed);

            if (road.checkBulletHitSomething(bulletsList)) {
                road.removeNodeFromRoad(bullet);
            }
        }));
    }

    private boolean bulletHitSomething(ImageView bullet) {

        return false;
    }




    //    public void moveLeft() {
//        if(location.getX() > WIDTH/6){
//            location = new Point2D(location.getX() - 15, location.getY());
//            setPosition();
//        }
//    }
//
//    public void moveRight() {
//        if(location.getX() < (road.theRoad.getWidth()- WIDTH/6)) {
//            location = new Point2D(location.getX() + 15, location.getY());
//            setPosition();
//        }
//    }
}
