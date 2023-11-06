package src;

public class NoPatternComparisonCode {
    public static void main(String[] args) {

        Entity entity;
        int random = (int) (Math.random() * 10);
        if (random == 1) {
            int enemyRandomNumber = (int) (Math.random() * 20);
            if (enemyRandomNumber <= 12) {
                entity = new BasicZombie();
            } else if (enemyRandomNumber <= 19) {
                entity = new LazerZombie();
            } else {
                entity = new BossZombie();
            }
        } else {
            int powerupRandomNumber = (int) (Math.random()*20);
            if (powerupRandomNumber <= 12) {
                entity = new EnergyPowerup();
            } else if (powerupRandomNumber <= 19){
                entity = new StarPowerup();
            } else {
                entity = new ExtraLifePowerup();
            }
        }





        entity.toString();


    }


}
