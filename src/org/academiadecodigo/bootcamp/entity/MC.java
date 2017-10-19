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
public class MC extends GameEntity implements Controllable {

    //Properties
    private boolean willShoot;


    //Constructor
    public MC(Grid grid) {

        super.setGrid(grid);
        super.setGridPosition(getPosition(grid));

        setDirection(null);

        willShoot = false;
    }


    private GridPosition getPosition(Grid grid) {

        int x = (int) (Math.floor(grid.getWidth() / 2));
        int y = grid.getHeight() - 150;

        Picture picture = new Picture(x, y, "images/pantoninho.png");

        return new GridPosition(grid, picture);
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
        super.setDirection(direction);
    }
}
