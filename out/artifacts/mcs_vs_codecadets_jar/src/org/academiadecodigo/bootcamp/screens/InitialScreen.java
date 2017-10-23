package org.academiadecodigo.bootcamp.screens;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 18/10/2017.
 */
public class InitialScreen {

    //Properties
    private Picture background;
    private Picture letters;
    private boolean drawn = false;
    private boolean notStarted = true;
    private Game game;

    //Constructor
    public InitialScreen(Game game) {
        background = new Picture(10, 10, "images/Evil-Pantoninho-800px.png");

        background.draw();
        letters = new Picture(10, 10, "insert.png");
        letters.grow(-900, -20);
        letters.translate(-850, 0);
        this.game = game;
    }

    public void show() {

        while (notStarted) {
            try {
                if (drawn) {
                    letters.delete();
                    drawn = false;
                    Thread.sleep(750);
                } else {
                    letters.draw();
                    drawn = true;
                    Thread.sleep(750);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        letters.delete();
        background.delete();
        System.out.println(Canvas.getInstance().getShapes().size());

        game.makeMenu();

    }


    public void stop() {
        notStarted = false;
    }

}
