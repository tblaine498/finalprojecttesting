package src.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
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

    @FXML
    public Label score;
    private PlayerCar playerCar;

    private List<Entity> aliveEntities = new ArrayList<>();

    private int scoreInt;

    /**
     * Width and height of road game-playing space
     */
    public static final int ROAD_WIDTH_HEIGHT = 600;

    /**
     * Amount of health reduction a bullet does to zombies
     */
    public static final int BULLET_HEALTH_AFFECT = 50;

    private final Creator[] creators = {new EnemyCreator(), new PowerupCreator()};

    private boolean gunCooldownActive = false;

    private long timeBenchmark;

    @FXML
    public void initialize() {
        playerCar = new PlayerCar(this, theRoad);
        scoreInt = 0;
        theRoad.setFocusTraversable(true);
        timeBenchmark = System.currentTimeMillis();
    }

    public void createNewEntity() {
        Creator entityCreator;
        int random = (int) (Math.random() * 10);
        if (random != 1) {
            entityCreator = creators[0];
        } else {
            entityCreator = creators[1];
        }

        Entity newEntity = entityCreator.createEntity(this);
        ImageView imageView = newEntity.getImageView();
        addNodeToRoad(imageView);
        aliveEntities.add(newEntity);
    }

    public void addNodeToRoad(Node node) {
        theRoad.getChildren().addAll(node);
    }

    public void checkBulletHitSomething(ImageView bullet, int bulletTimelineIndex, PlayerCar playerCar) {
        Entity entityToRemove = null;
        for (Entity entity : aliveEntities) {
            if (entity.getEntityType().equals("Enemy") && Math.abs(bullet.getX()-entity.getLocation().getX()) < 25
                    && Math.abs(bullet.getY()-entity.getLocation().getY()) < 25) {
                theRoad.getChildren().removeAll(bullet);
                playerCar.removeBullet(bulletTimelineIndex);

                scoreInt += 50;
                score.setText("Score: " + scoreInt);

                if (entity.reduceHealth(BULLET_HEALTH_AFFECT)) {
                    entityToRemove = entity;
                }
            }
        }
        if (entityToRemove!=null) {
            removeEntityFromRoad(entityToRemove);
        }
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

    public void removeEntityFromRoad(Entity entity) {
        aliveEntities.remove(entity);
        theRoad.getChildren().removeAll(entity.getImageView());
    }

    @FXML
    public void shoot(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.UP) {
            long timeNow = System.currentTimeMillis();
            if (timeNow-timeBenchmark >= 250) {
                playerCar.shoot();
                timeBenchmark = timeNow;
            }
        }
    }

    @FXML
    public void move(MouseEvent mouseEvent) {
        playerCar.move(mouseEvent);
    }

    public void startCreatingEntities() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> createNewEntity()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
