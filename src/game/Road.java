package src.game;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Road {
    @FXML
    public Pane theRoad;
    Player player;

    private List<Entity> aliveEntities = new ArrayList<>();

    public static final int ROAD_WIDTH_HEIGHT = 600;

    private Creator[] creators = {new PowerupCreator(), new EnemyCreator()};

    @FXML
    public void initialize() {
        player = new Player(this, theRoad);
        //code for managing Player object here


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000),(e)->{
            createNewEntity();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        theRoad.setFocusTraversable(true);
    }

    public void createNewEntity() {
        Creator entityCreator;
        int random = (int) (Math.random() * 10);
        if (random != 1) {
            entityCreator = creators[0];
        } else {
            entityCreator = creators[1];
        }

        Entity newEntity = entityCreator.createEntity();
        ImageView imageView = newEntity.getImageView();
        addNodeToRoad(imageView);
        aliveEntities.add(newEntity);
    }

    public void restart() {

    }

    public void addNodeToRoad(Node node) {
        theRoad.getChildren().addAll(node);
    }

//    public void onKeyPressed(KeyEvent keyEvent) {
//        if(keyEvent.getCode() == KeyCode.RIGHT) {
//            player.moveRight();
//        } else if (keyEvent.getCode() == KeyCode.LEFT) {
//            player.moveLeft();
//        } else if (keyEvent.getCode() == KeyCode.SPACE) {
//            player.shoot();
//        }
//    }

    public void removeNodeFromRoad(ImageView bullet) {
    }

    @FXML
    public void shoot(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.UP) {
            player.shoot();
        }
    }

    @FXML
    public void move(MouseEvent mouseEvent) {
        player.move(mouseEvent);
    }
}
