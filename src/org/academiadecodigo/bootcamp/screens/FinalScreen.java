package org.academiadecodigo.bootcamp.screens;


import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 21/10/2017.
 */
public class FinalScreen {

    //Properties
    private Picture image;

    //Constructor
    public FinalScreen() {
        image = new Picture(Grid.PADDING, Grid.PADDING, "resources/images/that-was-easy-800px.png");
        image.draw();
    }
}
