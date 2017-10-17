package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.Controllable;
import org.academiadecodigo.bootcamp.entity.GameEntity;
import org.academiadecodigo.bootcamp.entity.GameEntityFactory;
import org.academiadecodigo.bootcamp.entity.Movable;
import org.academiadecodigo.bootcamp.grid.Grid;

import java.util.ArrayList;

/**
 * Created by codecadet on 13/10/2017.
 */
public class Game {

    private Grid grid;
    public static ArrayList<GameEntity> gameEntities;
    private GameEntityFactory gameEntityFactory;
    private CollisionDetector collisionDetector;
    private Keyboard keyboard;

    //Constructor
    public Game() {
        this.grid = new Grid(100,80);
        this.gameEntityFactory = new GameEntityFactory();
        this.gameEntities = gameEntityFactory.getGameEntities(grid, 83);
        //this.collisionDetector = new CollisionDetector();
        this.keyboard = new Keyboard((Controllable) gameEntities.get(0));
    }

    public void start(){


        while(true) {

            for(Movable movable : gameEntities) {

                movable.move();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
