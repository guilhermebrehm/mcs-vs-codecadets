package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.Bullet;
import org.academiadecodigo.bootcamp.entity.Movable;
import org.academiadecodigo.bootcamp.entity.Shootable;

import java.util.ArrayList;

/**
 * Created by codecadet on 13/10/2017.
 */
public class CollisionDetector {

    private ArrayList<Bullet> bullets;
    private ArrayList<Bullet> bulletsToBeAdded;
    private ArrayList<Bullet> bulletsToBeRemoved;
    private ArrayList<Shootable> shootablesToBeShot;

    private ArrayList<Movable> movables;
    private ArrayList<Shootable> shootables;

    public CollisionDetector(ArrayList<Movable> movables, ArrayList<Shootable> shootables) {
        bullets = new ArrayList<>();
        bulletsToBeAdded = new ArrayList<>();
        bulletsToBeRemoved = new ArrayList<>();
        shootablesToBeShot = new ArrayList<>();

        this.movables = movables;
        this.shootables = shootables;
    }

    public void check() {

        for (Bullet bullet : bullets) {

            for (Shootable shootable : shootables) {

                if (shootable.getGridPosition().equals(bullet.getGridPosition())) {
                    shootablesToBeShot.add(shootable);
                    bulletsToBeRemoved.add(bullet);
                }

            }
        }

        removeBullets();
        addBullets();
        shootShootables();
    }

    public void addBullet(Bullet bullet) {

        bulletsToBeAdded.add(bullet);
    }

    private void addBullets() {

        for (Bullet bullet : bulletsToBeAdded) {
            bullets.add(bullet);
            movables.add(bullet);
        }

        bulletsToBeAdded.clear();
    }

    private void removeBullets() {

        for (Bullet bullet : bulletsToBeRemoved) {
            bullet.delete();
            bullets.remove(bullet);
            movables.remove(bullet);
        }

        bulletsToBeRemoved.clear();
    }

    private void shootShootables() {

        for (Shootable shootable : shootablesToBeShot) {

            shootable.getShot();

            if (shootable.isDead()) {
                shootables.remove(shootable);
            }
        }
    }

}
