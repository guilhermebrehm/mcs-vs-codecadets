package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.*;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.keyboards.InitialScreenKeyboard;
import org.academiadecodigo.bootcamp.keyboards.MenuScreenKeyboard;
import org.academiadecodigo.bootcamp.keyboards.OnePlayerKeyboard;
import org.academiadecodigo.bootcamp.keyboards.TwoPlayerKeyboard;
import org.academiadecodigo.bootcamp.screens.GameOverScreen;
import org.academiadecodigo.bootcamp.screens.InitialScreen;
import org.academiadecodigo.bootcamp.screens.LevelScreen;
import org.academiadecodigo.bootcamp.screens.FinalScreen;
import org.academiadecodigo.bootcamp.screens.MenuScreen;
import org.academiadecodigo.bootcamp.sound.SoundManager;
import org.academiadecodigo.bootcamp.sound.SoundType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

/**
 * Created by codecadet on 13/10/2017.
 */
public class Game {

    //Properties
    private Grid grid;
    private ArrayList<Movable> movables;
    public static CollisionDetector collisionDetector;
    private InitialScreen initialScreen;
    private KeyboardHandler kBH;
    private boolean twoPlayers;
    public static int NUM_LEVELS = 6;
    private MenuScreen menu;

    //Constructor
    public Game() {

        kBH = new InitialScreenKeyboard(this);

        initialScreen = new InitialScreen(this);
        initialScreen.show();

    }

    //Methods
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


            if(i != NUM_LEVELS -1) {
                new LevelScreen();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        new FinalScreen();
        SoundManager.playSound(SoundType.EASY);
    }

    private void loadLevel(int level) {

        grid = new Grid(800,600);
        Picture background = new Picture(10,10, "images/background-800px.png");
        background.draw();
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

        //TODO: insert batata_porra sound when 2P game ends

        this.grid = new Grid(800,600);
        Picture background = new Picture(10,10,"images/blackwood-800px.jpg");
        background.draw();
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

    public void makeMenu() {
        menu = new MenuScreen(this);
        kBH = new MenuScreenKeyboard(this);
        menu.chooseGame();
    }


    public MenuScreen getMenu() {
        return menu;
    }

    public void setTwoPlayers(boolean twoPlayers) {
        this.twoPlayers = twoPlayers;
    }
}
