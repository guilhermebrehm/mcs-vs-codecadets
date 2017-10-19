package org.academiadecodigo.bootcamp.entity;

import com.sun.tools.javac.jvm.Code;
import org.academiadecodigo.bootcamp.Game;
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


        int numRows = (numCadets / 4);

        for (int i = 1; i < numRows + 2; i++) {

            int numCadetsThisRow = (i == numRows + 1) ? numCadets % 4 : 4;

            int horizontalInterval = (grid.getWidth() - (numCadetsThisRow)) / (numCadetsThisRow + 1);
            int verticalInterval = (int) ((grid.getHeight() - (numRows + grid.getHeight() * .2)) / (numRows + 1));

            for (int j = 0; j < numCadetsThisRow; j++) {

                int x = horizontalInterval + (j * (horizontalInterval + 1));
                int y = i * verticalInterval;

                Picture picture = new Picture(x, y, "images/soldier.png");

                GridPosition position = new GridPosition(grid, picture);
                CodeCadet codeCadet = new CodeCadet(grid, position);

                codeCadets.add(codeCadet);
            }
        }

        return codeCadets;

    }

}
