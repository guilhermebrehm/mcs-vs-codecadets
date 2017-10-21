package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/10/2017.
 */
public class GameOverScreen {

    //Properties
    private Picture mashedPotato;
    private Picture gameOver;

    //Constructor
    public GameOverScreen() {
        int x = -50;
        int y = -100;
        mashedPotato = new Picture(x,y,"images/main-dish-mashed.png");
        mashedPotato.grow(-200,-200);
        gameOver = new Picture(x + 40, y + 250,"images/gameOver.png");
        gameOver.grow(-200,-50);
        mashedPotato.draw();
        gameOver.draw();
    }

    //Methods
    public void delete() {
        mashedPotato.delete();
        gameOver.delete();
    }
}
