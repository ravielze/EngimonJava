package com.engimon;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.engimon.menu.EMenu;
import com.engimon.sound.BackgroundSound;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        BackgroundSound.getInstance().start();
        EMenu.getInstance();
        // String filepath = "../Engi Images/test.wav";

        // AudioInputStream ais = AudioSystem.getAudioInputStream(new
        // File(filepath).getAbsoluteFile());
        // Clip clip = AudioSystem.getClip();
        // clip.open(ais);
        // clip.loop(Clip.LOOP_CONTINUOUSLY);
        // clip.start();
        // clip.stop();
        // while(true) {}
    }
}
