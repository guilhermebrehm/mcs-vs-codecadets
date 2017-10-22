package org.academiadecodigo.bootcamp.sound;

/**
 * Created by codecadet on 21/10/17.
 */
public enum SoundType {
    //TODO: inserir audios e seus paths
    BATATA("batata"),
    BATATAS("batatas"),
    BATATA_PORRA("batata_porra"),
    FODA_SE("fodase"), //quando mc toma tiro
    CONO("jesus"), //quando mc toma tiro
    ALVEJADO("alvejado"),
    BATATA_ARREBENTADA("batata_arrebentada"),
    PURE("xi_deu_pure");

    private String path;

    SoundType(String path) {
        this.path = "/audios/" + path + ".wav";
    }

    public String getPath() {
        return path;
    }
}
