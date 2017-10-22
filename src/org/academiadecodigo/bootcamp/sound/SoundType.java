package org.academiadecodigo.bootcamp.sound;

/**
 * Created by codecadet on 21/10/17.
 */
public enum SoundType {
    //TODO: inserir audios e seus paths
    BATATA("batata"),
    BATATAS("batata"),
    BATATA_PORRA("batata"),
    FODA_SE("fodase"), //quando mc toma tiro
    CONO("jesus"), //quando mc toma tiro
    ALVEJADO("alvejado"), //quando cadets tomam tiro
    BATATA_ARREBENTADA("batata_arrebentada"), //game over
    PURE("xi_deu_pure"); //game over

    private String path;

    SoundType(String path) {
        this.path = "/audios/" + path + ".wav";
    }

    public String getPath() {
        return path;
    }
}
