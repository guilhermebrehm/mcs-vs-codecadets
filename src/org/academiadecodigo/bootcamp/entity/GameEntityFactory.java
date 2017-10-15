package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Grid;

/**
 * Created by codecadet on 13/10/2017.
 */
public class GameEntityFactory {

    public static GameEntity[] getGameEntities(Grid grid){

        GameEntity[] gameEntities = new GameEntity[5];

        gameEntities[0] = new MC(grid);

        for(int i = 1; i< gameEntities.length;i++) {

            gameEntities[i] = new CodeCadet(grid,i);

        }

        return gameEntities;
    }
}
