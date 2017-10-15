package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;

/**
 * Created by codecadet on 13/10/2017.
 */
public class GameEntityFactory {

    public GameEntity[] getGameEntities(Grid grid, int numRows) {

        GameEntity[] gameEntities = new GameEntity[numRows * 4 + 1 ];

        gameEntities[0] = new MC(grid);

        int index = 1;

        for (CodeCadet codeCadet : getCodeCadets(numRows, grid)) {

            gameEntities[index] = codeCadet;

            index++;
        }

        return gameEntities;
    }

    public CodeCadet[] getCodeCadets(int numRows, Grid grid) {
        CodeCadet[] codeCadets = new CodeCadet[numRows * 4];

        int interval = (grid.getCols() - (4)) / (4 + 1);

        for (int i = 2; i < numRows + 2; i++) {

            for (int j = 0; j < 4; j++) {

                GridPosition position = new GridPosition(interval + (j * (interval + 1)), i * 8);

                codeCadets[j] = new CodeCadet(grid, position);

            }
        }


        return codeCadets;
    }

}
