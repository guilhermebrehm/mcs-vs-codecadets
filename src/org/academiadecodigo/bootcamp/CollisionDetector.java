package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.GameEntity;

/**
 * Created by codecadet on 13/10/2017.
 */
public class CollisionDetector {

    private GameEntity[] gameEntities;
    private Batata batata;

    public CollisionDetector(GameEntity[] gameEntities, Batata batata) {
        this.gameEntities = gameEntities;
        this.batata = batata;
    }

    public void check() {

        for (GameEntity entity : gameEntities) {

            if(entity.getGridPosition().equals(batata.getGridPosition())) {
                entity.getShot();
            }

        }

    }

}
