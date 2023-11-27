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
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;

public class PlayerCar {
    private static final int HEIGHT = 200;
    private static final int WIDTH = 200;
    private static boolean stopShooting = false;
    private final HBox hbox = new HBox();
    private Point2D location;
    private int lives = 3;
    private ImageView imageView;
    private Road road;
    private List<Timeline> bulletTimelineList = new ArrayList<>();

    public PlayerCar(Road road, Pane roadPane) {
        this.road = road;
        imageView = new ImageView(new Image("@../../src/objectImages/car.png"));
//        imageView.setFitHeight(HEIGHT);
//        imageView.setFitWidth(WIDTH);

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

        System.out.println(imageView.getFitWidth());
        System.out.println(imageView.getFitHeight());
    }

    public void hit(){
        if (lives > 0){
            hbox.getChildren().remove(--lives);
        }
    }

    public Point2D getLocation(){
        return location;
    }
    public int getLives(){
        return lives;
    }

    public ImageView getImageView(){
        return imageView;
    }

    private void setPosition() {
        double iconX = location.getX() - imageView.boundsInParentProperty().get().getWidth()/2;
        double iconY = location.getY() - imageView.boundsInParentProperty().get().getHeight()/2;
        imageView.relocate(iconX, iconY);
    }

    public void move(MouseEvent mouseEvent){
        if(mouseEvent.getX() >= 30 && mouseEvent.getX() <= 570){
            location = new Point2D(mouseEvent.getX(), location.getY());
            setPosition();


        }
    }

    public void removeBullet(int bulletTimelineIndex) {
        bulletTimelineList.get(bulletTimelineIndex).stop();
    }

    public void shoot() {
        if (lives != 0) {
            ImageView bullet = new ImageView(new Image("@../../src/objectImages/bullet.png"));
            bullet.setX(location.getX());
            bullet.setY(location.getY() - 80);
            road.addNodeToRoad(bullet);

            double bulletSpeed = 5.0;
            int bulletTimelineIndex = bulletTimelineList.size();
            Timeline timeline = getTimeline(bullet, bulletSpeed, bulletTimelineIndex);
            bulletTimelineList.add(timeline);

            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
    }

    private Timeline getTimeline(ImageView bullet, double bulletSpeed, int bulletIndex) {
        Duration duration = Duration.millis(16.7);

        return new Timeline(new KeyFrame(duration, event -> {
            bullet.setY(bullet.getY() - bulletSpeed);
            road.checkBulletHitSomething(bullet, bulletIndex, this);
        }));
    }

}
