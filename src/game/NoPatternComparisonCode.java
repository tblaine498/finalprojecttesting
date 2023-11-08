package src.game;

//DELETE THIS BEFORE FINAL SUBMISSION
public class NoPatternComparisonCode {
    public static void main(String[] args) {

        //code for managing Player object here

        Entity entity;
        int random = (int) (Math.random() * 10);
        if (random!=1) {
            int enemyRandomNumber = (int) (Math.random() * 20);
            if (enemyRandomNumber <= 12) {
                entity = new BasicZombie();
            } else if (enemyRandomNumber < 19) {
                entity = new LazerZombie();
            } else {
                entity = new BossZombie();
            }
        } else {
            int powerupRandomNumber = (int) (Math.random()*20);
            if (powerupRandomNumber <= 12) {
                entity = new EnergyPowerup();
            } else {
                entity = new ExtraLifePowerup();
            }
        }

        //code for exploring interaction between Entity and Player here




        entity.toString();


    }


}
