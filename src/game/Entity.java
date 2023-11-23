package src.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Entity {
    private int health;

    private Point2D location;

    private ImageView imageView;
    
    private String entityType;

    /**
     * Time between calls to step() (ms)
     * */
    public static final double MILLISECONDS_PER_STEP = 1000. / 30;
    public Entity(int health, String s, int size, String entityType) {     //pass in image as attribute, then create ImageView and show it in this class
        this.health = health;
        this.entityType = entityType;

        //randomize the x value of the starting location of the Entity, keep the y value consistent
        //location = new Point2D(x_location, y_location)

        int randomX = (int) (Math.random() * Road.ROAD_WIDTH_HEIGHT);
        location = new Point2D(randomX, -50);

        imageView = new ImageView(new Image(s));
        imageView.setFitHeight(size);
        imageView.setFitWidth(size);
        imageView.relocate(randomX, 50);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(MILLISECONDS_PER_STEP), e-> {
            step();
            checkOutOfBounds();
            if (location.getY() < Road.ROAD_WIDTH_HEIGHT) {
                //remove from road
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
    public String getEntityType() {
        return entityType;
    }

    public ImageView getImageView() {
        return imageView;
    }
    
    public Point2D getLocation() {
        return location;
    }

    public void setLocation(Point2D location) {
        this.location = location;

    }

    public int getHealth() {
        return health;
    }

    public void step() {
        location = location.add(new Point2D(0, 5));
        setPosition();
    }

    private void setPosition() {
        double imageViewX = location.getX() - imageView.boundsInParentProperty().get().getWidth()/2;
        double imageViewY = location.getY() - imageView.boundsInParentProperty().get().getHeight()/2;
        imageView.relocate(imageViewX, imageViewY);
    }

    private boolean checkOutOfBounds() {        //remove zombies if they get too far (actually remove them in Road)
        boolean outOfBounds = false;
        if (location.getY() > Road.ROAD_WIDTH_HEIGHT) {
            outOfBounds = true;
        }
        return outOfBounds;
    }

    public boolean reduceHealth(int bulletHealthAffect) {
        boolean entityDead = false;
        health -= bulletHealthAffect;
        if (health <= 0) {
            entityDead = true;
        }
        return entityDead;
    }
}
