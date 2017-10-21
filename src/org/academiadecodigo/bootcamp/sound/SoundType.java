package org.academiadecodigo.bootcamp.sound;

/**
 * Created by codecadet on 21/10/17.
 */
public enum SoundType {
    //TODO: inserir audios e seus paths
    BATATA("batata"),
    BATATAS("batata"),
    BATATA_PORRA("batata");

    private String path;

    SoundType(String path) {
        this.path = "/audios/" + path + ".wav";
    }

    public String getPath() {
        return path;
    }
}
