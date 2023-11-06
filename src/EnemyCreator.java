package src;

public class EnemyCreator implements Creator {
    @Override
    public Entity createObject() {
        int randomNumber = (int) (Math.random()*20);
        Entity enemyEntity;
        if (randomNumber <= 12) {
            enemyEntity = new BasicZombie();
        } else if (randomNumber <= 19) {
            enemyEntity = new LazerZombie();
        } else {
            enemyEntity = new BossZombie();
        }
        return enemyEntity;
    }
}
