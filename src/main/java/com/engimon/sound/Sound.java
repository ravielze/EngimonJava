package com.engimon.sound;

import javax.sound.sampled.Clip;

public class Sound {
    public static final Sound BATTLE_BGM = new Sound("Sounds/BGM/battle_bgm.wav");
    public static final Sound BEGINNING = new Sound("Sounds/BGM/game_beginning.wav");

    private Clip clip;

    public Sound(String filePath) {
        // ResourceReader rr = new ResourceReader(filePath);
        // try {
        // // BufferedInputStream bis = new BufferedInputStream(rr.getStream());
        // // AudioInputStream ais =
        // //
        // AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(filePath));
        // this.clip = AudioSystem.getClip();
        // clip.open(ais);
        // clip.loop(Clip.LOOP_CONTINUOUSLY);
        // clip.stop();
        // } catch (Exception silenced) {
        // }
    }

    public void play() {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

}