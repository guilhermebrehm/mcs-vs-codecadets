package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;

import java.util.ArrayList;

/**
 * Created by codecadet on 13/10/2017.
 */
public class GameEntityFactory {

    public ArrayList<Movable> getMovables(int numCadets, Grid grid) {

        ArrayList<Movable> codeCadets= new ArrayList<>();

        codeCadets.add(new MC(grid));

        int numRows = (numCadets / 4);

        for (int i = 1; i < numRows + 2; i++) {

            int numCadetsThisRow = (i == numRows + 1) ? numCadets % 4 : 4;

            int horizontalInterval = (grid.getCols() - (numCadetsThisRow)) / (numCadetsThisRow + 1);
            int verticalInterval = (int) ((grid.getRows() - (numRows + grid.getRows() * .2)) / (numRows + 1));

            for (int j = 0; j < numCadetsThisRow; j++) {

                GridPosition position = new GridPosition(horizontalInterval + (j * (horizontalInterval + 1)),
                        i * verticalInterval,
                        grid);

                codeCadets.add(new CodeCadet(grid, position));
            }
        }

        return codeCadets;

    }

}
