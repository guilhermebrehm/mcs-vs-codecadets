package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.Bullet;
import org.academiadecodigo.bootcamp.entity.Shootable;

import java.util.ArrayList;

/**
 * Created by codecadet on 13/10/2017.
 */
public class CollisionDetector {

    private ArrayList<Bullet> bullets;

    public void check() {

        for (Shootable shootable : Game.shootables) {

            if (shootable.getGridPosition().equals(bullet.getGridPosition())) {
                shootable.getShot();
            }

        }

    }

}
