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
    private Direction direction;

    //Constructor
    public Bullet(GameEntity entity) {

        setGridPosition(new GridPosition(entity.getGridPosition().getX(), entity.getGridPosition().getY() - Grid.CELL_SIZE, entity.getGrid()));
        getGridPosition().setColor(Color.RED);

        direction = entity.getDirection();
    }

    //Methods
    @Override
    public void move() {

        getGridPosition().moveInDirection(Direction.UP);
        getGridPosition().moveInDirection(direction);

        if (getGridPosition().getY() == Grid.PADDING) {
            delete();
        }
    }

    public void delete() {
        getGridPosition().delete();
    }

}
