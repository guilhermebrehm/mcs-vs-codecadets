package org.academiadecodigo.bootcamp.keyboards;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 22/10/2017.
 */
public class MenuScreenKeyboard implements KeyboardHandler{

    //Properties
    private Keyboard keyboard;
    private Game game;

    //Constructor
    public MenuScreenKeyboard(Game game) {
        this.game = game;
        this.keyboard = new Keyboard(this);

        KeyboardEvent press1 = new KeyboardEvent();
        press1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        press1.setKey(KeyboardEvent.KEY_1);

        KeyboardEvent press2 = new KeyboardEvent();
        press2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        press2.setKey(KeyboardEvent.KEY_2);

        keyboard.addEventListener(press1);
        keyboard.addEventListener(press2);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_1) {

            game.setTwoPlayers(false);
            game.getMenu().setNotChosen(false);

        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_2) {

            game.setTwoPlayers(true);
            game.getMenu().setNotChosen(false);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
