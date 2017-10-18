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

    private Rectangle rectangle;
    private boolean dead;
    private int directionCounter;

    //Constructor
    public CodeCadet(Grid grid, GridPosition gridPosition) {
        setGrid(grid);
        setGridPosition(gridPosition);

        int x = grid.colToX(gridPosition.getCol());
        int y = grid.rowToY(gridPosition.getRow());
        rectangle = new Rectangle(x - Grid.PADDING, y - Grid.PADDING, Grid.CELL_SIZE, Grid.CELL_SIZE);
        rectangle.setColor(Color.YELLOW);
        rectangle.fill();

        directionCounter = 10;
        setDirection(Direction.RIGHT);

    }


    public boolean isDead() {
        return dead;
    }


    @Override
    public void getShot() {
        rectangle.delete();
        dead = true;
    }

    @Override
    public void move() {

        if (dead) {
            return;
        }

        if (directionCounter % 20 == 0) {

            directionSwitch();
        }

        directionCounter++;

        int oldCol = getGridPosition().getCol();
        int oldRow = getGridPosition().getRow();

        getGridPosition().moveInDirection(getDirection());

        rectangle.translate((getGridPosition().getCol() - oldCol) * Grid.CELL_SIZE,
                (getGridPosition().getRow() - oldRow) * Grid.CELL_SIZE);
    }

    private void directionSwitch() {

        setDirection(Direction.values()[(getDirection().ordinal() + 2) % 4]);
    }
}
