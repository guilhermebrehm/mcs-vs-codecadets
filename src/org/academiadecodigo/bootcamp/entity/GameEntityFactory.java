package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;

/**
 * Created by codecadet on 13/10/2017.
 */
public class GameEntityFactory {

    public GameEntity[] getGameEntities(Grid grid, int numGameEntities) {

        GameEntity[] gameEntities = new GameEntity[numGameEntities];

        gameEntities[0] = new MC(grid);

        int index = 1;

        for (CodeCadet codeCadet : getCodeCadets(numGameEntities - 1, grid)) {

            gameEntities[index] = codeCadet;

            index++;
        }

        return gameEntities;
    }

    public CodeCadet[] getCodeCadets(int numCadets, Grid grid) {
        CodeCadet[] codeCadets = new CodeCadet[numCadets];

        int interval = (grid.getWidth() - (numCadets * Grid.CELL_SIZE))/numCadets + 1;

        int row = 1;

        for (int i = 0; i < numCadets; i++) {

            GridPosition position = new GridPosition(interval + i * (interval + Grid.CELL_SIZE), row);
            codeCadets[i] = new CodeCadet(grid, position);

            if(i % 4 == 0) {
                row++;
            }

        }
        return codeCadets;
    }

}
