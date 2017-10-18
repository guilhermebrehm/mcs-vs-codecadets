package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 18/10/2017.
 */
public class InitialScreen {

    //Properties
    private Picture background;
    private Picture letters;

    //Constructor
    public InitialScreen() {
        background = new Picture(10,10,"logo.png");
        background.draw();
        letters = new Picture(10,10,"insert.png");
        letters.grow(-700,-20);
        letters.translate(-550,650);
        letters.draw();
    }
}
