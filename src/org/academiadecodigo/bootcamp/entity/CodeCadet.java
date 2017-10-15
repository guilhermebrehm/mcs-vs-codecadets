package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Grid;

/**
 * Created by codecadet on 13/10/2017.
 */
public class CodeCadet extends GameEntity implements Shootable {

    //Constructor
    public CodeCadet(Grid grid,int i) {
        super.setGrid(grid);
        codeCadetPosition(i);

    }

    public void codeCadetPosition(int i) {
        super.setGridPosition((i*((super.getGrid().getWidth()-(4*super.getGrid().getCellSize())))/5)+((i-1)*super.getGrid().getCellSize()),1);
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
