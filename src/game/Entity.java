package src.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.util.Duration;

public abstract class Entity {
    private int health;

    private Point2D location;

    /**
     * Time between calls to step() (ms)
     * */
    public static final double MILLISECONDS_PER_STEP = 1000. / 30;
    public Entity(int health) {
        this.health = health;

        //randomize the x value of the starting location of the Entity, keep the y value consistent
        //location = new Point2D(x_location, y_location)

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(MILLISECONDS_PER_STEP), e-> step()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public int getHealth() {
        return health;
    }

    public void step() {
        //need to change location here
        setPosition();
    }

    private void setPosition() {
//        double iconCornerX = location.getX()- iconView.boundsInParentProperty().get().getWidth()/2;
//        double iconCornerY = location.getY()- iconView.boundsInParentProperty().get().getHeight()/2;
//        iconView.relocate(iconCornerX,iconCornerY);
//        double textCornerX =
//                location.getX()- nameText.boundsInParentProperty().get().getWidth()/2;
//        nameText.relocate(textCornerX, location.getY()+(double)HEIGHT/2+ TEXT_DISPLAY_FUDGE_FACTOR);
    }


}
