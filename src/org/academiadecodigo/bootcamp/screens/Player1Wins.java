package org.academiadecodigo.bootcamp.screens;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 22/10/2017.
 */
public class Player1Wins {

    //Properties
    private Picture image;

    //Constructor
    public Player1Wins() {
        image = new Picture(Grid.PADDING,Grid.PADDING,"images/player-1-win.png");
        image.draw();
    }

    //Methods
    public void hide() {
        image.delete();
    }
}
