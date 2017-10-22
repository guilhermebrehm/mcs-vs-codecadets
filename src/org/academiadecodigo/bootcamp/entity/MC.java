package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.grid.Direction;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 13/10/2017.
 */
public class MC extends GameEntity implements Controllable, Shootable {

    //Properties
    private boolean willShoot;
    private int health;
    private int playerNumber;

    //Constructor
    public MC(Grid grid, GridPosition gridPosition,boolean opposite, int playerNumber) {

        setOpposite(opposite);
        super.setGrid(grid);
        super.setGridPosition(gridPosition);

        setDirection(null);
        health = 3;

        willShoot = false;
        this.playerNumber = playerNumber;
    }

    public void shoot() {

        willShoot = true;
    }

    @Override
    public void move() {

        if (willShoot) {
            willShoot = false;
            Game.collisionDetector.addBullet(new Bullet(this));
        }

        getGridPosition().moveInDirection(getDirection());

    }

    @Override
    public void setDirection(Direction direction) {

        if(isOpposite() && direction != null) {
            direction = Direction.values()[(direction.ordinal() + 2) % 4];
        }

        super.setDirection(direction);
    }

    @Override
    public void getShot() {

        health--;
    }

    @Override
    public boolean isDead() {
        return (health <= 0);
    }

    public int getHealth() {
        return health;
    }
}
