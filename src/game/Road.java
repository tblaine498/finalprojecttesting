package src.game;

public class Road {
    public void run() {

        //code for managing Player object here

        Creator entityCreator;
        int random = (int) (Math.random() * 10);
        if (random!=1) {
            entityCreator = new EnemyCreator();
        } else {
            entityCreator = new PowerupCreator();
        }

        Entity newEntity = entityCreator.createEntity();

        //code for exploring interaction between Entity and Player here

        newEntity.toString(); //don't put this in code snippet
    }

}
