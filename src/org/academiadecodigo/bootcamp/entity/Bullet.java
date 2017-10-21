package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.grid.Direction;
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

        setOpposite(entity.isOpposite());
        System.out.println(isOpposite());

        int x = entity.getGridPosition().getX() + entity.getGridPosition().getWidth()/2;
        int y = entity.getGridPosition().getY() - 40;

        if(isOpposite()) {
            y = entity.getGridPosition().getMaxY();
        }

        Picture picture = new Picture(x,
                y, "images/potato.png");


        setGrid(entity.getGrid());
        setGridPosition(new GridPosition(entity.getGrid(), picture));

        direction = entity.getDirection();
    }

    //Methods
    @Override
    public void move() {

        if(isOpposite()){
            getGridPosition().moveInDirection(Direction.DOWN);
        } else {
            getGridPosition().moveInDirection(Direction.UP);
        }

        getGridPosition().moveInDirection(direction);
    }

    public void delete() {
        getGridPosition().delete();
    }

}
