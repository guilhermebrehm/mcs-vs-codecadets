package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/10/2017.
 */
public class LevelScreen {

    //Properties
    private Grid grid;
    private Picture fries;
    private Picture fries2;
    private Picture fries3;
    private Picture text;
    private Picture text2;
    private Picture potatoes;
    private Picture potatoes2;
    private Picture potatoes3;


    //Constructor
    public LevelScreen(Grid grid) {

        this.grid = new Grid(1400, 900);
        this.fries = new Picture(Grid.PADDING - 33, grid.getHeight() - 157 + Grid.PADDING, "images/french-fries.png");
        this.fries.grow(-33, 0);
        this.fries2 = new Picture(500 - 33 - 23, grid.getHeight() - 157 + Grid.PADDING, "images/french-fries.png");
        this.fries3 = new Picture(1000 - 33 - 40, grid.getHeight() - 157 + Grid.PADDING, "images/french-fries.png");
        this.fries3.grow(-17, 0);
        this.text = new Picture(130, 100, "images/Collecting-potatoes.png");
        this.text2 = new Picture(130, 220, "images/for-next-level.png");
        this.potatoes = new Picture(150 + Grid.PADDING, 400, "images/potatoes.png");
        this.potatoes2 = new Picture(grid.getWidth() / 2 - 150 + Grid.PADDING, 400, "images/potatoes.png");
        this.potatoes3 = new Picture(grid.getWidth() - 450 + Grid.PADDING, 400, "images/potatoes.png");
        this.fries.draw();
        this.fries2.draw();
        this.fries3.draw();
        this.text.draw();
        this.text2.draw();
        potatoLoader();
    }

    //Methods
    public void potatoLoader() {
        Picture[] potatoArray = new Picture[]{potatoes, potatoes2, potatoes3};

        try {
            for (Picture p : potatoArray) {
                Thread.sleep(1000);
                p.draw();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}






