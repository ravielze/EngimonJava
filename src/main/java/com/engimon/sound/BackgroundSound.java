package com.engimon.sound;

public class BackgroundSound extends Thread {

    private Sound currentPlaying;

    private static BackgroundSound instance;

    public BackgroundSound() {
    }

    public static BackgroundSound getInstance() {
        if (instance == null) {
            instance = new BackgroundSound();
        }
        return instance;
    }

    @Override
    public void run() {
        currentPlaying = null;
        while (true) {
        }
    }

    public void play(Sound sound) {
        if (currentPlaying != null) {
            currentPlaying.stop();
        }
        sound.play();
        currentPlaying = sound;
    }

    public void stopPlaying() {
        if (currentPlaying == null)
            return;
        currentPlaying.stop();
        currentPlaying = null;
    }

    public Sound getCurrentPlaying() {
        return currentPlaying;
    }

}
