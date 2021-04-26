package com.engimon.entity;

import com.engimon.menu.EMenu;

public class EntityTicking implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                if (i == 20) {
                    Spawner.getInstance().spawn();
                    i = 0;
                }
                Spawner.getInstance().randomMove();
                EMenu.MAIN_PAGE.update();
                EMenu.MAIN_PAGE.revalidate();
                Thread.sleep(1000);
            } catch (Exception ignored) {

            }
            i++;
        }
    }

}
