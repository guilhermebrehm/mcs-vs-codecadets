package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Direction;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;
import org.academiadecodigo.bootcamp.sound.SoundManager;
import org.academiadecodigo.bootcamp.sound.SoundType;

/**
 * Created by codecadet on 13/10/2017.
 */
public class CodeCadet extends GameEntity implements Shootable {

    private boolean dead;
    private int directionCounter;
    private int goingDownCounter;
    private boolean isGoingDown;
    private Direction previousDirection;

    //Constructor
    public CodeCadet(Grid grid, GridPosition gridPosition, Direction direction) {
        setGrid(grid);
        setGridPosition(gridPosition);

        setDirection(direction);

        dead = false;
        isGoingDown = false;
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

        if (isGoingDown){

            if(goingDownCounter % 20 == 0){

                directionSwitch();
                isGoingDown = false;
            }

            goingDownCounter++;
            getGridPosition().moveInDirection(getDirection());
            return;
        }


        if (directionCounter % (getGrid().getWidth() / 10) == 0) {

            isGoingDown = true;
            previousDirection = getDirection();
            setDirection(Direction.DOWN);
        }

        directionCounter++;

        getGridPosition().moveInDirection(getDirection());

    }

    private void directionSwitch() {

        setDirection(Direction.values()[(previousDirection.ordinal() + 2) % 4]);
    }
}
