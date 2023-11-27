package src.game;

public class EnemyCreator implements Creator {
    @Override
    public Entity createEntity(Road road) {
        double value = Math.random();
        return value <= 0.15 ? new BossZombie(road) : new BasicZombie(road);
    }
}
