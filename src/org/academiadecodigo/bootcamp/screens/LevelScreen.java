package org.academiadecodigo.bootcamp.screens;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/10/2017.
 */
public class LevelScreen {

    //Properties
    private Picture potatoes;
    private Picture potatoes2;
    private Picture potatoes3;
    private Picture potatoes4;
    private Picture potatoes5;
    private Picture potatoes6;


    //Constructor
    public LevelScreen() {

        this.potatoes = new Picture(Grid.PADDING, Grid.PADDING, "resources/images/lvl-screen-01.png");
        this.potatoes2 = new Picture(Grid.PADDING, Grid.PADDING, "resources/images/lvl-screen-02.png");
        this.potatoes3 = new Picture(Grid.PADDING, Grid.PADDING, "resources/images/lvl-screen-03.png");
        this.potatoes4 = new Picture(Grid.PADDING, Grid.PADDING, "resources/images/lvl-screen-04.png");
        this.potatoes5 = new Picture(Grid.PADDING, Grid.PADDING, "resources/images/lvl-screen-05.png");
        this.potatoes6 = new Picture(Grid.PADDING, Grid.PADDING, "resources/images/lvl-screen-06.png");
        potatoLoader();
    }

    //Methods
    public void potatoLoader() {
        Picture[] potatoArray = new Picture[]{potatoes, potatoes2, potatoes3, potatoes4, potatoes5, potatoes6};

        try {
            for (Picture p : potatoArray) {
                p.draw();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}






