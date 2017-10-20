package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/10/2017.
 */
public class FinalScreen {

    //Properties
    private Picture mashedPotato;
    private Picture gameOver;

    //Constructor
    public FinalScreen(int x, int y) {
        mashedPotato = new Picture(x,y,"images/main-dish-mashed.png");
        gameOver = new Picture(x + 40,y + 150,"images/gameOver.png");
        mashedPotato.draw();
        gameOver.draw();
    }

    //Methods
    public void delete() {
        mashedPotato.delete();
        gameOver.delete();
    }
}
