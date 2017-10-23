package org.academiadecodigo.bootcamp.sound;

/**
 * Created by codecadet on 21/10/17.
 */
public enum SoundType {
    BATATA("batata"),
    BATATAS("batatas"),
    BATATA_PORRA("batata_porra"),
    FODA_SE("fodase"),
    CONO("jesus"),
    ALVEJADO("alvejado"),
    BATATA_ARREBENTADA("batata_arrebentada"),
    PURE("xi_deu_pure"),
    EASY("that_was_easy"),
    COCO("coco");

    private String path;

    SoundType(String path) {
        this.path = "/audios/" + path + ".wav";
    }

    public String getPath() {
        return path;
    }
}
