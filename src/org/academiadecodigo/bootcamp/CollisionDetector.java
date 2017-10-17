package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.GameEntity;

/**
 * Created by codecadet on 13/10/2017.
 */
public class CollisionDetector {

    private GameEntity[] gameEntities;
    private Bullet bullet;

    public CollisionDetector(GameEntity[] gameEntities, Bullet bullet) {
        this.gameEntities = gameEntities;
        this.bullet = bullet;
    }

    public void check() {

        for (GameEntity entity : gameEntities) {

            if(entity.getGridPosition().equals(bullet.getGridPosition())) {
                entity.getShot();
            }

        }

    }

}
