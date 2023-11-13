package src.game;

import java.util.ArrayList;
import java.util.List;

public class EnemyCreator implements Creator {
    private List<Entity> list = new ArrayList<>();
    public EnemyCreator(){
        list.add(new BasicZombie());
        list.add(new LazerZombie());
        list.add(new BossZombie());
    }
    @Override
    public Entity createEntity() {
        return null;
    }
}
