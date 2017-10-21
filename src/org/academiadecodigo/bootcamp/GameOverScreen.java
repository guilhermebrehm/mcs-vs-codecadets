package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 21/10/2017.
 */
public class GameOverScreen {

    //Properties
    private Picture gameOver;

    //Constructor
    public GameOverScreen() {
        while(true) {
            gameOver = new Picture(10, 10, "images/Game-Over-800px.png");
            gameOver.draw();
        }
    }

}
