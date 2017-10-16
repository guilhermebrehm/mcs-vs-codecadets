package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;

import java.util.ArrayList;

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

        ArrayList<CodeCadet> codeCadets= new ArrayList<>();

        int numRows = (numCadets / 4);

        for (int i = 1; i < numRows + 2; i++) {

            int numCadetsThisRow = (i == numRows + 1) ? numCadets % 4 : 4;

            int horizontalInterval = (grid.getCols() - (numCadetsThisRow)) / (numCadetsThisRow + 1);
            int verticalInterval = (int) ((grid.getRows() - (numRows + grid.getRows() * .4)) / (numRows + 1));

            for (int j = 0; j < numCadetsThisRow; j++) {

                GridPosition position = new GridPosition(horizontalInterval + (j * (horizontalInterval + 1)),
                        i * verticalInterval,
                        grid);

                codeCadets.add(new CodeCadet(grid, position));
            }
        }

        return codeCadets.toArray(new CodeCadet[numCadets]);

    }

}
