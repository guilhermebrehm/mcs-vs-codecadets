package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.Bullet;
import org.academiadecodigo.bootcamp.entity.GameEntity;
import org.academiadecodigo.bootcamp.entity.Shootable;

import java.util.ArrayList;

/**
 * Created by codecadet on 13/10/2017.
 */
public class CollisionDetector {

    private ArrayList<GameEntity> gameEntities;
    private Bullet bullet;

    public CollisionDetector(ArrayList<GameEntity> gameEntities, Bullet bullet) {
        this.gameEntities = gameEntities;
        this.bullet = bullet;
    }

    public void check() {

        for (GameEntity gameEntity : gameEntities) {

            if (gameEntity instanceof Shootable) {

                if (gameEntity.getGridPosition().equals(bullet.getGridPosition())) {
                    ((Shootable) gameEntity).getShot();
                }
            }

        }

    }

}
