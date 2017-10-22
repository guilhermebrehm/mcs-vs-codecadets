package org.academiadecodigo.bootcamp.entity;

import com.sun.tools.javac.jvm.Code;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.GameLevel;
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

                Picture picture = new Picture(x, y, "images/parachutist.png");

                GridPosition position = new GridPosition(grid, picture);
                CodeCadet codeCadet = new CodeCadet(grid, position, initialDirection);

                codeCadets.add(codeCadet);
            }

            initialDirection = Direction.values()[(initialDirection.ordinal() + 2) % 4];
        }

        return codeCadets;

    }


    public ArrayList<CodeCadet> getCodeCadets(ArrayList<boolean[]> cadetPosConfig, Grid grid) {

        ArrayList<CodeCadet> codeCadets= new ArrayList<>();

        Direction initialDirection = Direction.RIGHT;

        int numRows = cadetPosConfig.size();

        for (int i = 0; i < numRows; i++) {

            int upperPadding = 10;
            int horizontalPadding = 80;
            int horizontalInterval = (grid.getWidth() - horizontalPadding) / (GameLevel.MAX_CADETS_PER_ROW + 2);
            int verticalInterval = (grid.getHeight() - upperPadding) / (numRows * 2);

            for (int j = 0; j < GameLevel.MAX_CADETS_PER_ROW; j++) {

                int x = horizontalPadding + horizontalInterval + (j * (horizontalInterval + 1));
                int y = upperPadding + i * verticalInterval;

                Picture picture = new Picture(x, y, "images/parachutist-resized.png");


                if(cadetPosConfig.get(i)[j]) {
                    GridPosition position = new GridPosition(grid, picture);
                    CodeCadet codeCadet = new CodeCadet(grid, position, initialDirection);
                    codeCadets.add(codeCadet);
                }
            }

            initialDirection = Direction.values()[(initialDirection.ordinal() + 2) % 4];
        }

        return codeCadets;

    }

}
