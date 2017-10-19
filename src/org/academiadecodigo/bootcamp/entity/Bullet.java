package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Direction;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 17/10/2017.
 */
public class Bullet extends GameEntity implements Movable {

    //Properties
    private Rectangle rectangle;
    private Direction direction;

    //Constructor
    public Bullet(GameEntity entity) {

        this.rectangle = new Rectangle(entity.getGridPosition().getCol() * Grid.CELL_SIZE,
                (entity.getGridPosition().getRow() - 1) * Grid.CELL_SIZE,
                Grid.CELL_SIZE, Grid.CELL_SIZE);

        this.rectangle.setColor(Color.RED);
        this.rectangle.fill();

        setGridPosition(new GridPosition(entity.getGridPosition().getCol(),
                entity.getGridPosition().getRow() - 1,
                entity.getGrid()));

        direction = entity.getDirection();
    }

    //Methods
    @Override
    public void move() {

        int initialX = getGridPosition().getCol();
        int initialY = getGridPosition().getRow();

        getGridPosition().moveInDirection(Direction.UP);
        getGridPosition().moveInDirection(direction);

        int finalX = getGridPosition().getCol();
        int finalY = getGridPosition().getRow();

        this.rectangle.translate((finalX - initialX) * Grid.CELL_SIZE, (finalY - initialY) * Grid.CELL_SIZE);

        // Delete rectangle if the bullet gets to the upper border
        if (initialY <= 1) {
            delete();
        }
    }

    public void delete() {
        rectangle.delete();
    }

}
