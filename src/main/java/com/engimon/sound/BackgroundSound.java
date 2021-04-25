package com.engimon.sound;

import java.util.Hashtable;

public class BackgroundSound extends Thread {
    private Sound beginningSound = new Sound("Sounds/BGM/battle_bgm.wav");
    private Sound battleSound = new Sound("Sounds/BGM/battle_bgm.wav"); // Ganti jadi beda


    private Hashtable<String, Sound> table = new Hashtable<String, Sound>();

    private String currentPlaying;

    private static BackgroundSound instance;

    public BackgroundSound() {
        table.put("beginning_sound", beginningSound);
        table.put("battle_sound", battleSound);
    }

    public static BackgroundSound getInstance() {
        if (instance == null) {
            instance = new BackgroundSound();
        }
        return instance;
    }

    @Override
    public void run() {
        currentPlaying = "beginning_sound";
        play(currentPlaying);
        while(true) {}
    }

    public void play(String sound) {
        if (!currentPlaying.equals("")) {
            table.get(currentPlaying).stop();
        }
        table.get(sound).play();
        currentPlaying = sound;
    }

    public void stopPlaying() {
        if (currentPlaying.equals("")) return;
        table.get(currentPlaying).stop();
        currentPlaying = "";
    }

    public String getCurrentPlaying() {return currentPlaying;}

}
