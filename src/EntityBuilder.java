package src;

public class EntityBuilder {
    public static Entity buildRandomEntity() {

        Creator objectCreator;
        int random = (int) (Math.random() * 10);
        if (random==1) {
            objectCreator = new PowerupCreator();
        } else {
            objectCreator = new EnemyCreator();
        }

        Entity newEntity = objectCreator.createEntity();
        return newEntity;

//        newEntity.toString(); //don't put this in code snippet
    }

}
