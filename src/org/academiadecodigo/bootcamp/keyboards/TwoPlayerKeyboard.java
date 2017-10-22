package org.academiadecodigo.bootcamp.keyboards;

import org.academiadecodigo.bootcamp.entity.Controllable;
import org.academiadecodigo.bootcamp.grid.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

/**
 * Created by codecadet on 13/10/2017.
 */
public class TwoPlayerKeyboard implements KeyboardHandler {

    private Keyboard keyboard;
    private Controllable controllable;
    private Controllable contrallable2;

    public TwoPlayerKeyboard(Controllable controllable1, Controllable controllable2) {

        this.controllable = controllable1;
        this.contrallable2 = controllable2;
        keyboard = new Keyboard(this);
        registerListeners();

    }

    public void setControllable(Controllable controllable) {
        this.controllable = controllable;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KEY_Q:
                controllable.setDirection(Direction.LEFT);
                break;

            case KEY_A:
                controllable.setDirection(Direction.RIGHT);
                break;

            case KEY_X:
                controllable.shoot();
                break;

            case KEY_O:
                contrallable2.setDirection(Direction.LEFT);
                break;

            case KEY_K:
                contrallable2.setDirection(Direction.RIGHT);
                break;

            case KEY_N:
                contrallable2.shoot();
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){

            case KEY_Q:
                controllable.setDirection(null);
                break;

            case KEY_A:
                controllable.setDirection(null);
                break;

            case KEY_X:
                break;

            case KEY_O:
                contrallable2.setDirection(null);
                break;

            case KEY_K:
                contrallable2.setDirection(null);
                break;

            case KEY_N:
                break;
        }
    }

    private void registerListeners() {

        KeyboardEvent a = new KeyboardEvent();
        a.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        a.setKey(KEY_A);

        KeyboardEvent q = new KeyboardEvent();
        q.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        q.setKey(KEY_Q);

        KeyboardEvent x = new KeyboardEvent();
        x.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        x.setKey(KEY_X);

        KeyboardEvent aR = new KeyboardEvent();
        aR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        aR.setKey(KEY_A);

        KeyboardEvent qR = new KeyboardEvent();
        qR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        qR.setKey(KEY_Q);

        /////////////////////////////////////////////////////////

        KeyboardEvent o = new KeyboardEvent();
        o.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        o.setKey(KEY_O);


        KeyboardEvent k = new KeyboardEvent();
        k.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.setKey(KEY_K);

        KeyboardEvent n = new KeyboardEvent();
        n.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        n.setKey(KEY_N);

        KeyboardEvent oR = new KeyboardEvent();
        oR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        oR.setKey(KEY_O);

        KeyboardEvent kR = new KeyboardEvent();
        kR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        kR.setKey(KEY_K);

        KeyboardEvent potato = new KeyboardEvent();
        potato.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        potato.setKey(KEY_P);

        keyboard.addEventListener(q);
        keyboard.addEventListener(a);
        keyboard.addEventListener(x);
        keyboard.addEventListener(qR);
        keyboard.addEventListener(aR);
        keyboard.addEventListener(o);
        keyboard.addEventListener(k);
        keyboard.addEventListener(n);
        keyboard.addEventListener(oR);
        keyboard.addEventListener(kR);
        keyboard.addEventListener(potato);
    }


}
