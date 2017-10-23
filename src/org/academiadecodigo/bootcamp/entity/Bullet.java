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
    private MC mc;

    //Constructor
    public Bullet(MC mc) {

        this.mc = mc;

        setOpposite(mc.isOpposite());

        int x = mc.getGridPosition().getX() + 30;
        int y = isOpposite() ? mc.getGridPosition().getMaxY() : mc.getGridPosition().getY() - 33;

        Picture picture = new Picture(x,
                y, "resources/images/potato-icon.png");

        if(mc.getPlayerNumber() == 2) {
            picture = new Picture(x,
                    y, "resources/images/coco.png");
        }


        setGrid(mc.getGrid());
        setGridPosition(new GridPosition(mc.getGrid(), picture));

        direction = mc.getDirection();
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

    public MC getMC() {
        return mc;
    }
}
