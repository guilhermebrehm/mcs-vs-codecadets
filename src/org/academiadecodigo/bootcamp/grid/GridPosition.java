package org.academiadecodigo.bootcamp.grid;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 13/10/2017.
 */
public class GridPosition {

    private Grid grid;
    private Rectangle rectangle;

    //Constructor
    public GridPosition(int x, int y, Grid grid) {

        this.grid = grid;

        rectangle = new Rectangle(Grid.PADDING + x, Grid.PADDING + y, Grid.CELL_SIZE, Grid.CELL_SIZE);
        rectangle.fill();
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

        rectangle.translate(0, yTranslate);
    }

    public void moveDown() {

        int yTranslate = (getMaxY() == grid.getHeight()) ? 0 : 1;

        rectangle.translate(0, yTranslate);
    }

    public void moveLeft() {

        int xTranslate = (getX() <= Grid.PADDING) ? 0 : -1;

        rectangle.translate(xTranslate, 0);
    }

    public void moveRight() {

        int xTranslate = (getMaxX() == grid.getWidth() + Grid.PADDING) ? 0 : 1;

        rectangle.translate(xTranslate, 0);
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    public int getWidth() {
        return rectangle.getWidth();
    }

    public int getHeight() {
        return rectangle.getHeight();
    }

    public int getMaxX() {
        return rectangle.getX() + getWidth();
    }

    public int getMaxY() {
        return rectangle.getY() + getHeight();
    }

    public boolean equals(GridPosition pos) {
        return getX() == pos.getX() && getY() == pos.getY();
    }

    public void delete() {
        rectangle.delete();
    }

    public void setColor(Color color) {
        rectangle.setColor(color);
    }


}
