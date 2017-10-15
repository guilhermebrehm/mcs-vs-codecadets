package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;

/**
 * Created by codecadet on 13/10/2017.
 */
public abstract class GameEntity implements Movable {

    private GridPosition gridPosition;
    private Grid grid;

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public void setGridPosition(int col,int row) {
        this.gridPosition = new GridPosition(col,row);
    }
    public void setGridPosition(GridPosition gridPosition) {
        this.gridPosition = gridPosition;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }
}
