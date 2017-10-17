package org.academiadecodigo.bootcamp.grid;


/**
 * Created by codecadet on 13/10/2017.
 */
public class GridPosition {

    private int col;
    private int row;
    private Grid grid;

    //Constructor
    public GridPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }


    public void moveInDirection(Direction direction) {

        if(direction == null) { return; }

        switch(direction) {

            case UP:
                moveUp();
                break;

            case DOWN:
                moveDown();
                break;

            case RIGHT:
                moveRight();
                break;

            case LEFT:
                moveLeft();
                break;
        }
    }

    private void moveUp() {

        row = (row <= 1) ? 1 : row - 1;
    }

    public void moveDown() {

        row = (row == grid.getRows()) ? grid.getRows() : row + 1;
    }

    public void moveLeft() {

        col = (col <= 1) ? 1 : col - 1;
    }

    public void moveRight() {

        col = (col == grid.getCols()) ? grid.getCols() : col + 1;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(GridPosition pos) {
        return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
    }
}
