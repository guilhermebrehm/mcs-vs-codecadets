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
        mashedPotato = new Picture(x,y,"images/mashed-potatoes.png");
        gameOver = new Picture(x - 125,y + 50,"images/gameOver.png");
        mashedPotato.draw();
        gameOver.draw();
    }

    //Methods
    public void delete() {
        mashedPotato.delete();
        gameOver.delete();
    }
}
