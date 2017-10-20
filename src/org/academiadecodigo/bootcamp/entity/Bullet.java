package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Direction;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 17/10/2017.
 */
public class Bullet extends GameEntity implements Movable {

    //Properties
    private Direction direction;

    //Constructor
    public Bullet(GameEntity entity) {

        Picture picture = new Picture(entity.getGridPosition().getX(),
                entity.getGridPosition().getY(), "images/potato-icon.png");

        setGridPosition(new GridPosition(entity.getGrid(), picture));
        getGridPosition().grow(-30, -30);

        direction = entity.getDirection();
    }

    //Methods
    @Override
    public void move() {

        getGridPosition().moveInDirection(Direction.UP);
        getGridPosition().moveInDirection(direction);


    }

    public void delete() {
        getGridPosition().delete();
    }

}
