package org.academiadecodigo.bootcamp.screens;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 21/10/2017.
 */
public class GameOverScreen {

    //Properties
    private Picture gameOver;

    //Constructor
    public GameOverScreen() {
        gameOver = new Picture(10, 10, "resources/images/Game-Over-800px.png");
        gameOver.draw();

        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
