package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.Bullet;
import org.academiadecodigo.bootcamp.entity.MC;
import org.academiadecodigo.bootcamp.entity.Movable;
import org.academiadecodigo.bootcamp.entity.Shootable;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.sound.Sound;
import org.academiadecodigo.bootcamp.sound.SoundManager;
import org.academiadecodigo.bootcamp.sound.SoundType;

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
    private MC mc;

    private SoundManager soundManager;

    boolean twoPlayers;

    public CollisionDetector(ArrayList<Movable> movables, ArrayList<Shootable> shootables, MC mc, boolean twoPlayers) {
        bullets = new ArrayList<>();
        bulletsToBeAdded = new ArrayList<>();
        bulletsToBeRemoved = new ArrayList<>();
        shootablesToBeShot = new ArrayList<>();

        this.movables = movables;
        this.shootables = shootables;

        this.mc = mc;

        soundManager = new SoundManager();
        this.twoPlayers = twoPlayers;
    }

    public void check() {

        for (Bullet bullet : bullets) {

            for (Shootable shootable : shootables) {

                int xMin = shootable.getGridPosition().getX();
                int yMin = shootable.getGridPosition().getY();

                int xMax = shootable.getGridPosition().getMaxX();
                int yMax = shootable.getGridPosition().getMaxY();

                int bulletX = bullet.getGridPosition().getX();
                int bulletY = bullet.getGridPosition().getY();

                int bulletMaxX = bullet.getGridPosition().getMaxX();
                int bulletMaxY = bullet.getGridPosition().getMaxY();

                if ((bulletX > xMin && bulletX < xMax) && (bulletY > yMin && bulletY < yMax) ||
                        (bulletMaxX > xMin && bulletMaxX < xMax) && (bulletMaxY > yMin && bulletMaxY < yMax) ||
                        (bulletMaxX > xMin && bulletX < xMax) && (bulletY > yMin && bulletY < yMax) ||
                        (bulletX > xMin && bulletX < xMax) && (bulletMaxY > yMin && bulletMaxY < yMax)) {
                    shootablesToBeShot.add(shootable);
                    bulletsToBeRemoved.add(bullet);
                }
            }

            if (bullet.getGridPosition().getY() == Grid.PADDING || bullet.getGridPosition().getMaxY() == bullet.getGrid().getHeight()) {
                bulletsToBeRemoved.add(bullet);
            }
        }

        removeBullets();
        addBullets();
        shootShootables();
    }

    public void addBullet(Bullet bullet) {

        bulletsToBeAdded.add(bullet);
        soundManager.playSound(SoundType.BATATA);

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

    public boolean isGameOver() {
        for (Shootable cadet : shootables) {
            if (cadet.getGridPosition().getMaxY() == mc.getGridPosition().getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean isLevelCompleted() {

        if(twoPlayers && shootables.size() == 1) {
            return true;
        }

        if(shootables.size() == 0) {
            return true;
        }

        return false;
    }

}
