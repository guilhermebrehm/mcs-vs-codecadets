package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.*;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.keyboards.InitialScreenKeyboard;
import org.academiadecodigo.bootcamp.keyboards.MenuScreenKeyboard;
import org.academiadecodigo.bootcamp.keyboards.OnePlayerKeyboard;
import org.academiadecodigo.bootcamp.keyboards.TwoPlayerKeyboard;
import org.academiadecodigo.bootcamp.screens.*;
import org.academiadecodigo.bootcamp.sound.SoundManager;
import org.academiadecodigo.bootcamp.sound.SoundType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.File;
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

                if (collisionDetector.isGameOver()) {
                    Screen gameOverScreen = new Screen("resources/images/Game-Over-800px.png");
                    gameOverScreen.draw(true);
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


            if (i != NUM_LEVELS - 1) {
                LevelScreen levelScreen = new LevelScreen();
                levelScreen.potatoLoader();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Screen finalScreen = new Screen("resources/images/that-was-easy-800px.png");
        finalScreen.draw();
        SoundManager.playSound(SoundType.EASY);
    }

    private void loadLevel(int level) {

        grid = new Grid(800, 600);

        Picture background = new Picture(10, 10, "resources/images/background-800px.png");
        background.draw();

        GameLevel gameLevel = new GameLevel("resources/levels/" + level + ".lvl");

        GameEntityFactory gameEntityFactory = new GameEntityFactory();
        ArrayList<CodeCadet> codeCadets = gameEntityFactory.getCodeCadets(gameLevel.getCadetArray(), grid);
        ArrayList<Shootable> shootables = new ArrayList<>(codeCadets);
        movables = new ArrayList<>(codeCadets);

        MC mc = gameEntityFactory.getMC(false, grid);
        movables.add(mc);

        collisionDetector = new CollisionDetector(movables, shootables, mc, false);

        kBH = new OnePlayerKeyboard(mc);

    }

    private void load2PlayerArena() {

        this.grid = new Grid(800, 600);
        Picture background = new Picture(10, 10, "resources/images/blackwood-800px.jpg");
        background.draw();

        GameEntityFactory gameEntityFactory = new GameEntityFactory();
        ArrayList<Shootable> shootables = new ArrayList<>();
        movables = new ArrayList<>();

        MC mc = gameEntityFactory.getMC(false, grid);
        MC mc2 = gameEntityFactory.getMC(true, grid);
        movables.add(mc);
        movables.add(mc2);
        shootables.add(mc);
        shootables.add(mc2);

        collisionDetector = new CollisionDetector(movables, shootables, mc, true);

        kBH = new TwoPlayerKeyboard(mc, mc2);

        Text player1Display = new Text(Grid.PADDING + 30, Grid.PADDING + 20, "");
        player1Display.grow(20, 10);
        Text player2Display = new Text(grid.getWidth() - 60, grid.getHeight() - 20, mc.getHealth() + "");
        player2Display.grow(20, 10);
        player1Display.setColor(Color.WHITE);
        player2Display.setColor(Color.WHITE);

        while (!collisionDetector.isLevelCompleted()) {

            for (Movable movable : movables) {

                movable.move();
            }

            collisionDetector.check();
            System.out.println(shootables.size());

            player2Display.setText("Life: " + mc.getHealth());
            player1Display.setText("Life: " + mc2.getHealth());
            player1Display.draw();
            player2Display.draw();

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        Screen victoryScreen = new Screen(
                "resources/images/player-" + ((MC) shootables.get(0)).getPlayerNumber() + "-win.png");
        victoryScreen.draw();
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
