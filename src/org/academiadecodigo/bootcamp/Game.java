package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.*;
import org.academiadecodigo.bootcamp.grid.Grid;

import java.util.ArrayList;

/**
 * Created by codecadet on 13/10/2017.
 */
public class Game {

    private Grid grid;
    public static ArrayList<Movable> movables;
    public static ArrayList<Shootable> shootables;
    private GameEntityFactory gameEntityFactory;
    private CollisionDetector collisionDetector;
    private Keyboard keyboard;
    private boolean started = false;

    //Constructor
    public Game() {
        this.grid = new Grid(100,80);
        this.gameEntityFactory = new GameEntityFactory();

        ArrayList<CodeCadet> codeCadets = gameEntityFactory.getCodeCadets(83, grid);
        movables = new ArrayList<>(codeCadets);
        shootables = new ArrayList<>(codeCadets);

        MC mc = new MC(grid);
        movables.add(mc);
        //this.collisionDetector = new CollisionDetector();
        this.keyboard = new Keyboard(mc);
    }

    public void start(){


        while(true) {

            for(Movable movable : movables) {

                movable.move();
            }

            for(Shootable shootable : shootables) {

                //Collision detecotr checkskjfoaifhoiw
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    /*
    public boolean initialScreen() {



    }
    */


}
