package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.grid.Direction;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

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

        getGridPosition().setColor(Color.WHITE);

        willShoot = false;
    }


    private GridPosition getPosition(Grid grid) {

        int x = (int) (Math.floor(grid.getWidth() / 2));
        int y = grid.getHeight() - Grid.CELL_SIZE;

        return new GridPosition(x, y, grid);
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
