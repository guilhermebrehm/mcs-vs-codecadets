package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 13/10/2017.
 */
public class MC extends GameEntity {

    //Properties
    private Rectangle rectangle;


    //Constructor
    public MC(Grid grid) {
        super.setGrid(grid);
        super.setGridPosition(getPosition(grid));

        int x = grid.colToX(getGridPosition().getCol()) - Grid.PADDING;
        int y = grid.rowToY(getGridPosition().getRow()) - Grid.PADDING;

        rectangle = new Rectangle(x, y, Grid.CELL_SIZE, Grid.CELL_SIZE);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
    }


    private GridPosition getPosition(Grid grid) {

        int col = (int)(Math.floor(grid.getCols() / 2));
        int row = grid.getRows();

        return new GridPosition(col, row);
    }

    public void shoot() {

        throw new UnsupportedOperationException();
    }

    @Override
    public void move() {

        throw new UnsupportedOperationException();
    }
}
