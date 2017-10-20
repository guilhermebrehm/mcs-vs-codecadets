package org.academiadecodigo.bootcamp.entity;

import com.sun.tools.javac.jvm.Code;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.grid.Direction;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

/**
 * Created by codecadet on 13/10/2017.
 */
public class GameEntityFactory {

    public ArrayList<CodeCadet> getCodeCadets(int numCadets, Grid grid) {

        ArrayList<CodeCadet> codeCadets= new ArrayList<>();

        Direction initialDirection = Direction.RIGHT;

        int numRows = (numCadets / 4);

        for (int i = 1; i < numRows + 2; i++) {

            int numCadetsThisRow = (i == numRows + 1) ? numCadets % 4 : 4;

            int horizontalInterval = (grid.getWidth() - (numCadetsThisRow)) / (numCadetsThisRow + 1);
            int upperPadding = 10;
            int verticalInterval = (grid.getHeight() - upperPadding) / (numRows * 2);

            for (int j = 0; j < numCadetsThisRow; j++) {

                int x = horizontalInterval + (j * (horizontalInterval + 1));
                int y = upperPadding + i * verticalInterval;

                Picture picture = new Picture(x, y, "images/soldier.png");

                GridPosition position = new GridPosition(grid, picture);
                CodeCadet codeCadet = new CodeCadet(grid, position, initialDirection);

                codeCadets.add(codeCadet);
            }

            initialDirection = Direction.values()[(initialDirection.ordinal() + 2) % 4];
        }

        return codeCadets;

    }

}
