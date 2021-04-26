package com.engimon.entity;

public class Spawning implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Spawner.getInstance().print("abc");
                Thread.sleep(2000);
            } catch (Exception ignored) {

            }
        }
    }

}
