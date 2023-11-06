package src;

public class PowerupCreator implements Creator {

    @Override
    public Entity createObject() {
        int randomNumber = (int) (Math.random()*20);
        Entity powerupEntity;
        if (randomNumber <= 12) {
            powerupEntity = new EnergyPowerup();
        } else if (randomNumber <= 19){
            powerupEntity = new StarPowerup();
        } else {
            powerupEntity = new ExtraLifePowerup();
        }
        return powerupEntity;
    }
}
