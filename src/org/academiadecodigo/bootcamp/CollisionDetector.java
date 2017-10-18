package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.Bullet;
import org.academiadecodigo.bootcamp.entity.GameEntity;
import org.academiadecodigo.bootcamp.entity.Shootable;

import java.util.ArrayList;

/**
 * Created by codecadet on 13/10/2017.
 */
public class CollisionDetector {

    private ArrayList<Shootable> shootables;
    private Bullet bullet;

    public CollisionDetector(ArrayList<Shootable> shootables, Bullet bullet) {
        this.shootables = shootables;
        this.bullet = bullet;
    }

    public void check() {

        for (Shootable shootable : shootables) {

            if(shootable.getGridPosition().equals(bullet.getGridPosition())) {
                shootable.getShot();
            }

        }

    }

}
