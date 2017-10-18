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
    private Rectangle rectangle;


    //Constructor
    public MC(Grid grid) {

        super.setGrid(grid);
        super.setGridPosition(getPosition(grid));

        int x = grid.colToX(getGridPosition().getCol()) - Grid.PADDING;
        int y = grid.rowToY(getGridPosition().getRow()) - Grid.PADDING;

        setDirection(null);

        rectangle = new Rectangle(x, y, Grid.CELL_SIZE, Grid.CELL_SIZE);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
    }


    private GridPosition getPosition(Grid grid) {

        int col = (int)(Math.floor(grid.getCols() / 2));
        int row = grid.getRows() - 1;

        return new GridPosition(col, row, grid);
    }

    public void shoot() {

        Game.movables.add(new Bullet(this));
    }

    @Override
    public void move() {

        int oldCol = getGridPosition().getCol();
        int oldRow = getGridPosition().getRow();

        getGridPosition().moveInDirection(getDirection());

        rectangle.translate((getGridPosition().getCol() - oldCol) * Grid.CELL_SIZE,
                (getGridPosition().getRow() - oldRow) * Grid.CELL_SIZE);
    }

    @Override
    public void setDirection(Direction direction) {
        super.setDirection(direction);
    }
}
