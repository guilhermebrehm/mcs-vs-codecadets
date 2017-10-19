package org.academiadecodigo.bootcamp.grid;


import org.academiadecodigo.simplegraphics.graphics.*;

/**
 * Created by codecadet on 13/10/2017.
 */
public class GridPosition {

    private Grid grid;
    private Shape shape;

    //Constructor
    public GridPosition(int x, int y, Grid grid) {

        this.grid = grid;

        shape = new Rectangle(Grid.PADDING + x, Grid.PADDING + y, Grid.CELL_SIZE, Grid.CELL_SIZE);
        ((Rectangle) shape).fill();
    }

    public GridPosition(Grid grid, Shape shape) {

        if(!(shape instanceof Movable)) {
            System.out.println("FUCK YOU RETARD WHAT THE FUCK YOU TRYNA DO?!?!!111!?!?! ..bitch");
        }

        this.grid = grid;

        this.shape = shape;
        shape.draw();
    }



    public void moveInDirection(Direction direction) {

        if (direction == null) {
            return;
        }

        switch (direction) {

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

        int yTranslate = (getY() <= Grid.PADDING) ? 0 : -1;

        ((Movable) shape).translate(0, yTranslate);
    }

    public void moveDown() {

        int yTranslate = (getMaxY() == grid.getHeight()) ? 0 : 1;

        ((Movable) shape).translate(0, yTranslate);
    }

    public void moveLeft() {

        int xTranslate = (getX() <= Grid.PADDING) ? 0 : -1;

        ((Movable) shape).translate(xTranslate, 0);
    }

    public void moveRight() {

        int xTranslate = (getMaxX() == grid.getWidth() + Grid.PADDING) ? 0 : 1;

        ((Movable) shape).translate(xTranslate, 0);
    }

    public int getX() {
        return shape.getX();
    }

    public int getY() {
        return shape.getY();
    }

    public int getWidth() {
        return shape.getWidth();
    }

    public int getHeight() {
        return shape.getHeight();
    }

    public int getMaxX() {
        return shape.getX() + getWidth();
    }

    public int getMaxY() {
        return shape.getY() + getHeight();
    }

    public boolean equals(GridPosition pos) {
        return getX() == pos.getX() && getY() == pos.getY();
    }

    public void delete() {
        shape.delete();
    }

    public void setColor(Color color) {
        ((Colorable) shape).setColor(color);
    }

    public void setShape(){
        this.shape = shape;
    }

    public void grow(double v1, double v2) {
        shape.grow(v1, v2);
    }


}
