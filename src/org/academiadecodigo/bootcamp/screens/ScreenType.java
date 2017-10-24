package org.academiadecodigo.bootcamp.screens;

/**
 * Created by codecadet on 24/10/2017.
 */
public enum  ScreenType {

    GAME_OVER("Game-Over-800px"),
    THAT_WAS_EASY("that-was-easy-800px"),
    PLAYER_1_WIN("resources/images/player-1-win"),
    PLAYER_2_WIN("resources/images/player-1-win");

    private String path;

    ScreenType(String path) {
        this.path = "resources/images/" + path + ".png";
    }

    public String getPath() {
        System.out.println(path);
        return path;
    }
}
