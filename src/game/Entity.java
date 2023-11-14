package src.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Entity {
    private int health;

    private Point2D location = new Point2D(0, 0);

    private ImageView imageView;

    /**
     * Time between calls to step() (ms)
     * */
    public static final double MILLISECONDS_PER_STEP = 1000. / 30;
    public Entity(int health, String s, int size) {     //pass in image as attribute, then create ImageView and show it in this class
        this.health = health;

        //randomize the x value of the starting location of the Entity, keep the y value consistent
        //location = new Point2D(x_location, y_location)

        int testing = (int) (Math.random() * Road.ROAD_WIDTH_HEIGHT);
        location = new Point2D(testing, -50);

        imageView = new ImageView(new Image(s));
        imageView.setFitHeight(size);
        imageView.setFitWidth(size);
        imageView.relocate(testing, 50);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(MILLISECONDS_PER_STEP), e-> {
            step();
            if (location.getY() < Road.ROAD_WIDTH_HEIGHT) {
                //remove from road
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public ImageView getImageView() {
        return imageView;
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

    private void setPosition() {        //change corner name?
        double iconCornerX = location.getX();
        double iconCornerY = location.getY();
        imageView.relocate(iconCornerX, iconCornerY);
    }

    private boolean checkOutOfBounds() {        //remove zombies if they get too far (actually remove them in Road)
        boolean outOfBounds = false;
        if (location.getY() > Road.ROAD_WIDTH_HEIGHT) {
            outOfBounds = true;
        }
        return outOfBounds;
    }

}
