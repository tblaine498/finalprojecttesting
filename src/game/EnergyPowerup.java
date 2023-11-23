package src.game;


//increases the step size of the Player for a few seconds, then sets it back to normal
public class EnergyPowerup extends Entity {
    public EnergyPowerup() {
        super(100, "@../../src/objectImages/BasicZombie.jpg", 50, "Powerup");
    }
}
