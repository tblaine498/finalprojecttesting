package src.game;

public class PowerupCreator implements Creator {
    @Override
    public Entity createEntity(Road road) {
        double value = Math.random();
        return value <= 0.15 ? new StarPowerup(road) : new EnergyPowerup(road);
    }
}

