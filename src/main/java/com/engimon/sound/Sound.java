package com.engimon.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.engimon.common.ResourceReader;

public class Sound {

    private Clip clip;

    public Sound(String filePath) {
        ResourceReader rr = new ResourceReader(filePath);
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(rr.getStream());
            // AudioInputStream ais = AudioSystem.getAudioInputStream(new
            // File(filePath).getAbsoluteFile());
            this.clip = AudioSystem.getClip();
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.stop();
        } catch (Exception silenced) {

        }
    }

    public void play() {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

}