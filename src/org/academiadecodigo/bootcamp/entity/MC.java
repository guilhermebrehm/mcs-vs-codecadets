package org.academiadecodigo.bootcamp.entity;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.grid.Direction;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 13/10/2017.
 */
public class MC extends GameEntity implements Controllable, Shootable {

    //Properties
    private boolean willShoot;
    private boolean dead;

    //Constructor
    public MC(Grid grid) {

        super.setGrid(grid);
        super.setGridPosition(getPosition(grid));

        setDirection(null);

        willShoot = false;
    }

    public MC(Grid grid, boolean opposite) {

        setOpposite(opposite);
        super.setGrid(grid);
        super.setGridPosition(getPosition(grid));

        setDirection(null);

        willShoot = false;
    }


    private GridPosition getPosition(Grid grid) {

        int x = (int) (Math.floor(grid.getWidth() / 2));
        int y = grid.getHeight() - 150;

        if(isOpposite()) {
            x = (int) (Math.floor(grid.getWidth() / 2));
            y = 150 + Grid.PADDING;
        }

        Picture picture = new Picture(x, y, "images/pantoninho.png");

        return new GridPosition(grid, picture);
    }

    public void shoot() {

        willShoot = true;
    }

    @Override
    public void move() {

        if (willShoot) {
            willShoot = false;
            Game.collisionDetector.addBullet(new Bullet(this));
            System.out.println("passei");
        }

        getGridPosition().moveInDirection(getDirection());
        System.out.println("moved");

    }

    @Override
    public void setDirection(Direction direction) {

        if(isOpposite() && direction != null) {
            direction = Direction.values()[(direction.ordinal() + 2) % 4];
        }

        super.setDirection(direction);
    }

    @Override
    public void getShot() {
        dead = true;
    }

    @Override
    public boolean isDead() {
        return dead;
    }

}
