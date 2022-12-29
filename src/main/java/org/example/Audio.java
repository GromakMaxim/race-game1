package org.example;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static java.util.Objects.requireNonNull;

public class Audio implements Runnable {
    @Override
    public void run() {
        try {
            Player musicPlayer = new Player(new FileInputStream(
                    requireNonNull(this.getClass().getResource("/music/song1.mp3")).getPath()
            ));
            musicPlayer.play();
        } catch (JavaLayerException | FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
