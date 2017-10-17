package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Direction;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 17/10/2017.
 */
public class Bullet implements Movable{

    //Properties
    private Rectangle rectangle;
    private GridPosition gridPosition;

    //Constructor
    public Bullet(GameEntity entity) {
        this.rectangle = new Rectangle(entity.getGridPosition().getCol(),entity.getGridPosition().getRow() - 1,
                Grid.CELL_SIZE,Grid.CELL_SIZE);
        this.rectangle.setColor(Color.RED);
        this.rectangle.fill();
        this.gridPosition = new GridPosition(entity.getGridPosition().getCol(),
                entity.getGridPosition().getRow() -1,entity.getGrid());
    }

    //Methods
    @Override
    public void move() {

        int initialX = this.gridPosition.getCol();
        int initialY = this.gridPosition.getRow();

        this.gridPosition.moveInDirection(Direction.UP);

        int finalX = this.gridPosition.getCol();
        int finalY = this.gridPosition.getRow();

        this.rectangle.translate(finalX-initialX,finalY-initialY);
    }
}
