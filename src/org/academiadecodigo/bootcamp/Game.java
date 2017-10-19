package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.*;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

/**
 * Created by codecadet on 13/10/2017.
 */
public class Game {

    private Grid grid;
    private ArrayList<Movable> movables;
    private ArrayList<Shootable> shootables;
    private GameEntityFactory gameEntityFactory;
    public static CollisionDetector collisionDetector;
    private Keyboard keyboard;
    private InitialScreen initialScreen;

    //Constructor
    public Game() {

        //this.grid = new Grid(1400, 900);
        this.grid = new Grid(600, 400);
        this.gameEntityFactory = new GameEntityFactory();

        ArrayList<CodeCadet> codeCadets = gameEntityFactory.getCodeCadets(17, grid);
        movables = new ArrayList<>(codeCadets);
        shootables = new ArrayList<>(codeCadets);

        MC mc = new MC(grid);
        movables.add(mc);
        collisionDetector = new CollisionDetector(movables, shootables);
        this.keyboard = new Keyboard(mc);
    }

    public void start() {

        while (true) {

            for (Movable movable : movables) {

                movable.move();
            }

            System.out.println(movables.size());

            collisionDetector.check();

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}
