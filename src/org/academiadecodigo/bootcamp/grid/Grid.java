package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 13/10/2017.
 */
public class Grid {

    private int cols;
    private int rows;
    private Rectangle rectangle;
    public static int CELL_SIZE = 10;
    private int width;
    private int height;
    public static int PADDING = 10;

    //Constructor
    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.width = cols * CELL_SIZE;
        this.height = rows * CELL_SIZE;
        rectangle = new Rectangle(PADDING, PADDING, width, height);
        rectangle.draw();
    }

    public int colToX(int col){
        return col * CELL_SIZE + PADDING;
    }

    public int rowToY(int row){
        return row * CELL_SIZE + PADDING;
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
