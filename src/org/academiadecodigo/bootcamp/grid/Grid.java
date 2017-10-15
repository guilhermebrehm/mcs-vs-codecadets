package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 13/10/2017.
 */
public class Grid {

    private int cols;
    private int rows;
    private Rectangle rectangle;
    private int cellSize = 10;
    private int width;
    private int height;
    private int padding = 10;

    //Constructor
    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.width = cols * cellSize;
        this.height = rows * cellSize;
    }

    public int colToX(int col){
        return col * cellSize + padding;
    }

    public int rowToY(int row){
        return row * cellSize + padding;
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getCellSize() {
        return cellSize;
    }
}
