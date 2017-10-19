package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.*;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

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
    private InitialScreen initialScreen;
    private KeyboardHandler kBH;

    //Constructor
    public Game() {

        kBH = new InitialScreenKeyboard(this);

        initialScreen = new InitialScreen(this);
        initialScreen.show();


    }

    public void start() {

        init();

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

    public void init() {

        this.grid = new Grid(1400, 900);
        this.gameEntityFactory = new GameEntityFactory();

        ArrayList<CodeCadet> codeCadets = gameEntityFactory.getCodeCadets(20, grid);
        movables = new ArrayList<>(codeCadets);
        shootables = new ArrayList<>(codeCadets);

        MC mc = new MC(grid);
        movables.add(mc);
        collisionDetector = new CollisionDetector(movables, shootables);
        kBH = new GameKeyboard(mc);
    }

    public InitialScreen getInitialScreen() {
        return initialScreen;
    }
}
