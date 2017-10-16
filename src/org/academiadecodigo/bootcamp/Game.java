package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.GameEntity;
import org.academiadecodigo.bootcamp.entity.GameEntityFactory;
import org.academiadecodigo.bootcamp.grid.Grid;

/**
 * Created by codecadet on 13/10/2017.
 */
public class Game {

    private Grid grid;
    private GameEntity[] gameEntities;
    private GameEntityFactory gameEntityFactory;
    private CollisionDetector collisionDetector;

    //Constructor
    public Game() {
        this.grid = new Grid(100,80);
        this.gameEntityFactory = new GameEntityFactory();
        this.gameEntities = gameEntityFactory.getGameEntities(grid, 10);
        this.collisionDetector = new CollisionDetector();
    }

    public void start(){



    }
}
