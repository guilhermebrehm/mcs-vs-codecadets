package org.academiadecodigo.bootcamp.sound;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by codecadet on 21/10/17.
 */
public class SoundManager {

    private static HashMap<SoundType, Sound> SOUNDMAP = new HashMap<>();

    public SoundManager() {

        for (SoundType soundType : SoundType.values()) {
            try {
                SOUNDMAP.put(soundType, new Sound(soundType.getPath()));

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void playSound(SoundType soundType){
        Sound currSound = SOUNDMAP.get(soundType);

        if(currSound == null) {
            System.out.println("No sound available");
            return;
        }
        //System.out.println(currSound.isPlaying());
        currSound.play(true);
    }

    public static void playGameOverSound() {
        Sound gameOverSound;

        if((int)(Math.random() * 2) == 0) {
            gameOverSound = SOUNDMAP.get(SoundType.BATATA_ARREBENTADA);
        } else {
            gameOverSound = SOUNDMAP.get(SoundType.PURE);
        }
        gameOverSound.play(true);
    }
}
