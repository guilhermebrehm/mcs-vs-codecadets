package org.academiadecodigo.bootcamp.grid;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 13/10/2017.
 */
public class GridPosition {

    private int x;
    private int y;
    private Grid grid;
    private Rectangle rectangle;

    //Constructor
    public GridPosition(int x, int y, int width, int height, Grid grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;

        rectangle = new Rectangle(Grid.PADDING + x, Grid.PADDING + y, Grid.CELL_SIZE, Grid.CELL_SIZE);
        rectangle.fill();
    }

    public GridPosition(int x, int y, Grid grid) {

        this.x = x;
        this.y = y;

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

        int initialY = y;
        y = (y <= 1) ? 1 : y - 1;

        rectangle.translate(0, y - initialY);
    }

    public void moveDown() {

        int initialY = y;
        y = (y == grid.getHeight()) ? grid.getHeight() : y + 1;

        rectangle.translate(0, y - initialY);
    }

    public void moveLeft() {

        int initialX = x;
        x = (x <= 1) ? 1 : x - 1;

        rectangle.translate(x - initialX, 0);
    }

    public void moveRight() {

        int initialX = x;
        x = (x == grid.getWidth()) ? grid.getWidth() : x + 1;

        rectangle.translate(x - initialX, 0);
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
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
