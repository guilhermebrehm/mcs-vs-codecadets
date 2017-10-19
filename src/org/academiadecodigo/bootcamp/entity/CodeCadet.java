package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Direction;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 13/10/2017.
 */
public class CodeCadet extends GameEntity implements Shootable {

    private boolean dead;
    private int directionCounter;

    //Constructor
    public CodeCadet(Grid grid, GridPosition gridPosition) {
        setGrid(grid);
        setGridPosition(gridPosition);

        directionCounter = 10;
        setDirection(Direction.RIGHT);

        dead = false;
    }

    @Override
    public void getShot() {
        getGridPosition().delete();
        dead = true;
    }

    @Override
    public boolean isDead() {
        return dead;
    }

    @Override
    public void move() {

        if (dead) {
            return;
        }

        if (directionCounter % 100 == 0) {

            directionSwitch();
        }

        directionCounter++;

        getGridPosition().moveInDirection(getDirection());

    }

    private void directionSwitch() {

        setDirection(Direction.values()[(getDirection().ordinal() + 2) % 4]);
    }
}
