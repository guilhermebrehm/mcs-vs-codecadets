package org.academiadecodigo.bootcamp.screens;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/10/2017.
 */
public class LevelScreen {

    //Methods
    public void potatoLoader() {

        try {
            for (int i = 0; i < 6; i++) {

                Picture picture = new Picture(Grid.PADDING, Grid.PADDING, "resources/images/lvl-screen-0" + (i+1) + ".png");
                picture.draw();
                Thread.sleep(500);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}






