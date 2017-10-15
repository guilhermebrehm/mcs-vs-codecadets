package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 13/10/2017.
 */
public class CodeCadet extends GameEntity implements Shootable {

    private Rectangle rectangle;

    //Constructor
    public CodeCadet(Grid grid, GridPosition gridPosition) {
        super.setGrid(grid);
        super.setGridPosition(gridPosition);

        int x = grid.colToX(gridPosition.getCol());
        int y = grid.rowToY(gridPosition.getRow());
        rectangle = new Rectangle(x - Grid.PADDING, y - Grid.PADDING, Grid.CELL_SIZE, Grid.CELL_SIZE);
        rectangle.fill();
    }

    @Override
    public void getShot() {

        throw new UnsupportedOperationException();
    }

    @Override
    public void move() {

       throw new UnsupportedOperationException();
    }
}
