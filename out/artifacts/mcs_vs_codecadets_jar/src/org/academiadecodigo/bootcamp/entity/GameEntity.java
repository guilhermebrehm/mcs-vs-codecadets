package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Direction;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;

/**
 * Created by codecadet on 13/10/2017.
 */
public abstract class GameEntity implements Movable {

    private GridPosition gridPosition;
    private Grid grid;
    private Direction direction;
    private boolean opposite;

    public GridPosition getGridPosition() {
        return gridPosition;
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isOpposite() {
        return opposite;
    }

    public void setOpposite(boolean opposite) {
        this.opposite = opposite;
    }
}
