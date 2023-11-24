package src.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
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
    PlayerCar playerCar;

    private List<Entity> aliveEntities = new ArrayList<>();

    public static final int ROAD_WIDTH_HEIGHT = 600;
    public static final int BULLET_HEALTH_AFFECT = 50;

    private Creator[] creators = {new EnemyCreator(), new PowerupCreator()};

    @FXML
    public void initialize() {
        playerCar = new PlayerCar(this, theRoad);
        //code for managing Player object here

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

        Entity newEntity = entityCreator.createEntity(this);
        ImageView imageView = newEntity.getImageView();
        addNodeToRoad(imageView);
        aliveEntities.add(newEntity);
    }

    public void restart() {

    }

    public void addNodeToRoad(Node node) {
        theRoad.getChildren().addAll(node);
    }

    public boolean checkBulletHitSomething(List<ImageView> bullets) {
        List<Entity> entitiesToRemove = new ArrayList<>();
        boolean bulletsHitSomething = false;
        for (ImageView bullet : bullets) {
            for (Entity entity : aliveEntities) {
                if (entity.getEntityType().equals("Enemy") && Math.abs(bullet.getX()-entity.getLocation().getX()) < 20
                        && Math.abs(bullet.getY()-entity.getLocation().getY()) < 20) {

                    System.out.println("enemy hit");
                    if (entity.reduceHealth(BULLET_HEALTH_AFFECT)) {
                        entitiesToRemove.add(entity);
                        bulletsHitSomething = true;
                    }
                }
            }
        }

        for (Entity entity : entitiesToRemove) {
            removeEntityFromRoad(entity);
        }
        return bulletsHitSomething;
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

    public void removeBulletFromRoad(Node node) {
        theRoad.getChildren().removeAll(node);
    }

    @FXML
    public void shoot(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.UP) {
            playerCar.shoot();
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
