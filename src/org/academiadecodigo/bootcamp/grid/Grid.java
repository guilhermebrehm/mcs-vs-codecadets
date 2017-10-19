package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 13/10/2017.
 */
public class Grid {

    private Rectangle rectangle;
    public static int CELL_SIZE = 10;
    private int width;
    private int height;
    public static int PADDING = 10;

    //Constructor
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        rectangle = new Rectangle(PADDING, PADDING, width, height);
        rectangle.fill();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
