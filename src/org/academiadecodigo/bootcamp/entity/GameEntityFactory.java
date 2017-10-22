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

    private int playerNumber;

    public GameEntityFactory() {

        playerNumber = 1;
    }

    public ArrayList<CodeCadet> getCodeCadets(ArrayList<boolean[]> cadetPosConfig, Grid grid) {

        ArrayList<CodeCadet> codeCadets = new ArrayList<>();

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

                if (cadetPosConfig.get(i)[j]) {
                    GridPosition position = new GridPosition(grid, picture);
                    CodeCadet codeCadet = new CodeCadet(grid, position, initialDirection);
                    codeCadets.add(codeCadet);
                }
            }

            initialDirection = Direction.values()[(initialDirection.ordinal() + 2) % 4];
        }

        return codeCadets;

    }


    public MC getMC(boolean opposite, Grid grid) {

        int x = (int) (Math.floor(grid.getWidth() / 2));
        int y = opposite ? Grid.PADDING + 30 : grid.getHeight() - 140;

        Picture picture = new Picture(x, y, "images/pantoninho.png");

        if (playerNumber == 2) {
            picture = new Picture(x, y, "images/rodolfo.png");

        }

        GridPosition gridPosition = new GridPosition(grid, picture);

        return new MC(grid, gridPosition, opposite, playerNumber++);

    }


}
