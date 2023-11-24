package src.game;

import java.util.ArrayList;
import java.util.List;

public class PowerupCreator implements Creator {
    private List<Entity> powerupList = new ArrayList<>();
    public PowerupCreator(){

    }
    @Override
    public Entity createEntity(Road road) {
        return new StarPowerup(road);
    }
}

