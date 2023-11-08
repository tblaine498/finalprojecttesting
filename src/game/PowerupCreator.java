package src.game;

public class PowerupCreator implements Creator {
    @Override
    public Entity createEntity() {
        int randomNumber = (int) (Math.random()*20);
        Entity powerupEntity;
        if (randomNumber <= 12) {
            powerupEntity = new EnergyPowerup();
        } else {
            powerupEntity = new ExtraLifePowerup();
        }
        return powerupEntity;
    }
}

