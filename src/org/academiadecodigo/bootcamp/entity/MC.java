package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;

/**
 * Created by codecadet on 13/10/2017.
 */
public class MC extends GameEntity {

    //Properties


    //Constructor
    public MC(Grid grid) {
        super.setGrid(grid);
        mCPosition(grid);
    }


    public void mCPosition(Grid grid) {

        int col = (int)(Math.floor(grid.getWidth() / 2));
        int row = grid.getHeight();

        super.setGridPosition(col,row);
    }

    public void shoot() {

        throw new UnsupportedOperationException();
    }

    @Override
    public void move() {

        throw new UnsupportedOperationException();
    }
}
