package src;

public class Road {
    public void run() {
        Creator objectCreator;
        int random = (int) (Math.random() * 10);
        if (random==1) {
            objectCreator = new PowerupCreator();
        } else {
            objectCreator = new EnemyCreator();
        }




        objectCreator.toString();
    }

}
