package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.*;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.*;
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
    private KeyboardHandler kBH1;
    private boolean twoPlayers;
    public static int NUM_LEVELS = 6;

    //Constructor
    public Game(boolean twoPlayers) {

        kBH = new InitialScreenKeyboard(this);

        this.twoPlayers = twoPlayers;
        initialScreen = new InitialScreen(this, grid);
        initialScreen.show();

    }

    public void start() {

        if (twoPlayers) {
            load2PlayerArena();
            return;
        }

        outerloop:
        for (int i = 0; i < NUM_LEVELS; i++) {

            loadLevel(i);

            while (!collisionDetector.isLevelCompleted()) {

                if(collisionDetector.isGameOver()){
                    new GameOverScreen();
                    break outerloop;
                }

                for (Movable movable : movables) {

                    movable.move();
                }

                collisionDetector.check();

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            LevelScreen levelScreen = new LevelScreen(grid);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        new FinalScreen(grid);

    }

    private void loadLevel(int level) {

        grid = new Grid(800,600);
        GameLevel gameLevel = new GameLevel("levels/" + level + ".lvl");
        GameEntityFactory gameEntityFactory = new GameEntityFactory();
        ArrayList<CodeCadet> codeCadets = gameEntityFactory.getCodeCadets(gameLevel.getCadetArray(), grid);
        ArrayList<Shootable> shootables = new ArrayList<>(codeCadets);
        movables = new ArrayList<>(codeCadets);
        MC mc = new MC(grid);
        movables.add(mc);
        collisionDetector = new CollisionDetector(movables, shootables, mc, false);
        kBH = new OnePlayerKeyboard(mc);

    }

    private void load2PlayerArena() {
        this.grid = new Grid(1400, 900);
        ArrayList<Shootable> shootables = new ArrayList<>();
        movables = new ArrayList<>();
        MC mc = new MC(grid);
        MC mc2 = new MC(grid, true);
        movables.add(mc);
        movables.add(mc2);
        shootables.add(mc);
        shootables.add(mc2);
        collisionDetector = new CollisionDetector(movables, shootables, mc, true);
        kBH = new TwoPlayerKeyboard(mc, mc2);

        while (!collisionDetector.isLevelCompleted()) {

            for (Movable movable : movables) {

                movable.move();
            }

            collisionDetector.check();

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public InitialScreen getInitialScreen() {
        return initialScreen;
    }


}
