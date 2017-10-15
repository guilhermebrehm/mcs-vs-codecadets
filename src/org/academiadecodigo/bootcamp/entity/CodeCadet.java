package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;

/**
 * Created by codecadet on 13/10/2017.
 */
public class CodeCadet extends GameEntity implements Shootable {

    //Constructor
    public CodeCadet(Grid grid, GridPosition gridPosition) {
        super.setGrid(grid);
        super.setGridPosition(gridPosition);
    }

    public void codeCadetPosition(int i) {
        super.setGridPosition((i*((super.getGrid().getWidth()-(4*Grid.CELL_SIZE)))/5)+((i-1)*Grid.CELL_SIZE),1);
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
