package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;

/**
 * Created by codecadet on 13/10/2017.
 */
public class GameEntityFactory {

    public GameEntity[] getGameEntities(Grid grid, int numCadets) {

        GameEntity[] gameEntities = new GameEntity[numCadets + 1];

        gameEntities[0] = new MC(grid);

        int index = 1;

        for (CodeCadet codeCadet : getCodeCadets(numCadets, grid)) {

            gameEntities[index] = codeCadet;

            index++;
        }

        return gameEntities;
    }


    public CodeCadet[] getCodeCadets(int numCadets, Grid grid) {

        CodeCadet[] codeCadets = new CodeCadet[numCadets];

        int numRows = numCadets / 4;

        for (int i = 1; i < numRows + 1; i++) {

            int numCadetsThisRow = (i == numRows) ? numCadets % 4 : 4;

            int interval = (grid.getCols() - (numCadetsThisRow)) / (numCadetsThisRow + 1);

            for (int j = 0; j < numCadetsThisRow; j++) {

                GridPosition position = new GridPosition(interval + (j * (interval + 1)), i * 8);

                codeCadets[j] = new CodeCadet(grid, position);
            }
        }

        return codeCadets;
    }

}
