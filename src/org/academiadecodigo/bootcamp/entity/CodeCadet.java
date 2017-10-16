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
    private int directionCounter;

    //Constructor
    public CodeCadet(Grid grid, GridPosition gridPosition) {
        super.setGrid(grid);
        super.setGridPosition(gridPosition);

        int x = grid.colToX(gridPosition.getCol());
        int y = grid.rowToY(gridPosition.getRow());
        rectangle = new Rectangle(x - Grid.PADDING, y - Grid.PADDING, Grid.CELL_SIZE, Grid.CELL_SIZE);
        rectangle.setColor(Color.YELLOW);
        rectangle.fill();

        super.setDirection(Direction.RIGHT);

    }

    @Override
    public void getShot() {

        throw new UnsupportedOperationException();
    }

    @Override
    public void move() {

        if(directionCounter % 8 == 0) {

            directionSwitch();
        }

        directionCounter++;

        int oldCol = getGridPosition().getCol();
        int oldRow = getGridPosition().getRow();

        getGridPosition().moveInDirection(getDirection());

        rectangle.translate((getGridPosition().getCol() - oldCol) * Grid.CELL_SIZE,
                (getGridPosition().getRow() - oldRow) * Grid.CELL_SIZE);
    }

    public void directionSwitch() {

        super.setDirection(Direction.values()[(super.getDirection().ordinal() + 2) % 4]);
    }
}
