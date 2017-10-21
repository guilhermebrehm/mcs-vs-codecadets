package org.academiadecodigo.bootcamp;


import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 21/10/2017.
 */
public class FinalScreen {

    //Properties
    private Rectangle background;
    private Picture text;

    //Constructor
    public FinalScreen(Grid grid) {
        background = new Rectangle(Grid.PADDING,Grid.PADDING,grid.getWidth(),grid.getHeight());
        background.fill();
        text = new Picture(130 + Grid.PADDING, 300, "images/goodwintext.png");
        text.draw();
    }
}
