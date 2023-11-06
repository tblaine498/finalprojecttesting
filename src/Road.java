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

        Entity newEntity = objectCreator.createObject();


        newEntity.toString(); //don't put this in code snippet
    }

}
