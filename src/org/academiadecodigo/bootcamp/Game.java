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
    public static int NUM_LEVELS = 6;

    //Constructor
    public Game() {

        kBH = new InitialScreenKeyboard(this);

        initialScreen = new InitialScreen(this);
        initialScreen.show();
    }

    public void start() {

        outerloop:
        for (int i = 0; i < NUM_LEVELS ; i++) {

            loadLevel(i);

            while (!collisionDetector.isLevelCompleted()) {

                if(collisionDetector.isGameOver()){
                    new GameOverScreen((this.grid.getWidth() / 2) - 457, 10);
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

            if(i != NUM_LEVELS-1) {
                LevelScreen levelScreen = new LevelScreen(grid);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(i == NUM_LEVELS-1) {
                new FinalScreen(grid);
            }
        }



    }

    private void loadLevel(int level) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        this.grid = new Grid(width, height);
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

    public InitialScreen getInitialScreen() {
        return initialScreen;
    }


}
