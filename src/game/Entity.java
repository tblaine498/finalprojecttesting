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

    /**
     * Time between calls to step() (ms)
     * */
    public static final double MILLISECONDS_PER_STEP = 1000. / 30;
    public Entity(int health) {     //pass in image as attribute, then create ImageView and show it in this class
        this.health = health;

        //randomize the x value of the starting location of the Entity, keep the y value consistent
        //location = new Point2D(x_location, y_location)
        imageView = new ImageView(new Image("@../../src/objectImages/BasicZombie.jpg"));       //why like this?
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);


//        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(MILLISECONDS_PER_STEP), e-> step()));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setLocation(Point2D location) {
        location = location;

    }
    public int getHealth() {
        return health;
    }

    public void step() {
        location.add(new Point2D(0, 10));
        setPosition();
    }

    private void setPosition() {        //change corner name?
        double iconCornerX = location.getX() - imageView.boundsInParentProperty().get().getWidth()/2;
        double iconCornerY = location.getY() - imageView.boundsInParentProperty().get().getHeight()/2;
        imageView.relocate(iconCornerX, iconCornerY);
    }


}
