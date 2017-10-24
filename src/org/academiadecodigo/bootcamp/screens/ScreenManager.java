package org.academiadecodigo.bootcamp.screens;

/**
 * Created by codecadet on 24/10/2017.
 */
public class ScreenManager {

    public static void displayScreen(ScreenType screenType) {

        Screen screen = new Screen(screenType.getPath());
        screen.draw();
    }

    public static void displayScreen(ScreenType screenType, boolean hold) {

        Screen screen = new Screen(screenType.getPath());
        screen.draw(hold);
    }



}
