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
    public static CollisionDetector collisionDetector;
    private InitialScreen initialScreen;
    private KeyboardHandler kBH;
    public static int NUM_LEVELS = 1;

    //Constructor
    public Game() {

        kBH = new InitialScreenKeyboard(this);

        initialScreen = new InitialScreen(this);
        initialScreen.show();


    }

    public void start() {

        for (int i = 0; i < NUM_LEVELS ; i++) {

            init();

            while (!collisionDetector.isGameOver()) {

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

        FinalScreen finalScreen = new FinalScreen((this.grid.getWidth() / 2) - 457, 10);
    }

    public void init() {

        this.grid = new Grid(1400, 900);
        GameEntityFactory gameEntityFactory = new GameEntityFactory();

        GameLevel gameLevel = new GameLevel("levels/0.lvl");

        ArrayList<CodeCadet> codeCadets = gameEntityFactory.getCodeCadets(gameLevel.getCadetArray(), grid);
        movables = new ArrayList<>(codeCadets);
        ArrayList<Shootable> shootables = new ArrayList<>(codeCadets);

        MC mc = new MC(grid);
        movables.add(mc);
        collisionDetector = new CollisionDetector(movables, shootables, mc);
        kBH = new GameKeyboard(mc);
    }

    public InitialScreen getInitialScreen() {
        return initialScreen;
    }


}
