package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.entity.Controllable;
import org.academiadecodigo.bootcamp.grid.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import sun.jvm.hotspot.memory.Space;

import java.security.Key;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

/**
 * Created by codecadet on 13/10/2017.
 */
public class GameKeyboard implements KeyboardHandler {

    private Keyboard keyboard;
    private Controllable controllable;

    public GameKeyboard(Controllable controllable) {

        this.controllable = controllable;
        keyboard = new Keyboard(this);
        registerListeners();
    }

    public void setControllable(Controllable controllable) {
        this.controllable = controllable;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KEY_RIGHT:
                controllable.setDirection(Direction.RIGHT);
                break;

            case KEY_LEFT:
                controllable.setDirection(Direction.LEFT);
                break;

            case KEY_SPACE:
                controllable.shoot();
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        controllable.setDirection(null);
    }

    private void registerListeners() {

        KeyboardEvent pressRightArrow = new KeyboardEvent();
        pressRightArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressRightArrow.setKey(KEY_RIGHT);

        KeyboardEvent pressLeftArrow = new KeyboardEvent();
        pressLeftArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressLeftArrow.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent pressSpace = new KeyboardEvent();
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressSpace.setKey(KEY_SPACE);

        KeyboardEvent releaseRightArrow = new KeyboardEvent();
        releaseRightArrow.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseRightArrow.setKey(KEY_RIGHT);

        KeyboardEvent releaseLeftArrow = new KeyboardEvent();
        releaseLeftArrow.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseLeftArrow.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent potato = new KeyboardEvent();
        potato.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        potato.setKey(KEY_P);

        keyboard.addEventListener(pressLeftArrow);
        keyboard.addEventListener(pressRightArrow);
        keyboard.addEventListener(releaseLeftArrow);
        keyboard.addEventListener(releaseRightArrow);
        keyboard.addEventListener(pressSpace);
        keyboard.addEventListener(potato);
    }


}