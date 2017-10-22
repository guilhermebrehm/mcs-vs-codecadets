package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by codecadet on 22/10/2017.
 */
public class MenuScreen {

    //Properties
    private Picture menu;
    private Game game;
    private boolean notChosen = true;

    //Constructor
    public MenuScreen(Game game) {
        this.game = game;
        menu = new Picture(Grid.PADDING,Grid.PADDING,"images/menuscreen.png");
        menu.draw();
    }

    //Methods
    public void chooseGame() {

        while(notChosen) {
            try {
                    Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("deu cócó no choose game");
            }
        }

        menu.delete();

        game.start();

    }

    public void setNotChosen(boolean bool) {
        this.notChosen = bool;
    }

}
