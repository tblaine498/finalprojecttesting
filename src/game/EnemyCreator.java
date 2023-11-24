package src.game;

import java.util.ArrayList;
import java.util.List;

public class EnemyCreator implements Creator {
    private List<Entity> enemyList = new ArrayList<>();
    public EnemyCreator(){
//        enemyList.add(new BasicZombie());
//        enemyList.add(new LazerZombie());
//        enemyList.add(new BossZombie());
    }
    @Override
    public Entity createEntity(Road road) {
        return new BossZombie(road);
    }
}
