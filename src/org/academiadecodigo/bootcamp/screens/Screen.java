package org.academiadecodigo.bootcamp.screens;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 24/10/2017.
 */
public class Screen {

    private String imagePath;

    public Screen(String imagePath) {

        this.imagePath = imagePath;
    }

    public void draw() {

        Picture picture = new Picture(Grid.PADDING, Grid.PADDING, imagePath);
        picture.draw();
    }

    public void draw(boolean hold) {

        draw();

        while(hold) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
