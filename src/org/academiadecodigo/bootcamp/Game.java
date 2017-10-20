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
    public static int NUM_LEVELS = 2;
    private boolean twoPlayers;

    //Constructor
    public Game(boolean twoPlayers) {

        kBH = new InitialScreenKeyboard(this);

        initialScreen = new InitialScreen(this);
        initialScreen.show();

        this.twoPlayers = twoPlayers;
    }

    public void start() {

        if(twoPlayers){
           load2PlayerArena();
           return;
        }

        outerloop:
        for (int i = 0; i < NUM_LEVELS ; i++) {

            loadLevel(i);

            while (!collisionDetector.isLevelCompleted()) {

                if(collisionDetector.isGameOver()){
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

        FinalScreen finalScreen = new FinalScreen((this.grid.getWidth() / 2) - 457, 10);
    }

    private void loadLevel(int level) {

        this.grid = new Grid(1400, 900);
        GameLevel gameLevel = new GameLevel("levels/" + level + ".lvl");
        GameEntityFactory gameEntityFactory = new GameEntityFactory();
        ArrayList<CodeCadet> codeCadets = gameEntityFactory.getCodeCadets(gameLevel.getCadetArray(), grid);
        ArrayList<Shootable> shootables = new ArrayList<>(codeCadets);
        movables = new ArrayList<>(codeCadets);
        MC mc = new MC(grid);
        movables.add(mc);
        collisionDetector = new CollisionDetector(movables, shootables, mc);
        kBH = new GameKeyboard(mc);

    }

    private void load2PlayerArena() {
        this.grid = new Grid(1400, 900);
        ArrayList<Shootable> shootables = new ArrayList<>();
        movables = new ArrayList<>();
        MC mc = new MC(grid);
        MC mc2 = new MC(grid);
        movables.add(mc);
        movables.add(mc2);
        collisionDetector = new CollisionDetector(movables, shootables, mc);
        kBH = new GameKeyboard(mc);
        kBH1 = new GameKeyboard(mc);
    }

    public InitialScreen getInitialScreen() {
        return initialScreen;
    }


}
