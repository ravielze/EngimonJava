package com.engimon;

import com.engimon.entity.Game;
import com.engimon.menu.EMenu;

public class App {

    public static void main(String[] args) {
        Game.firstLoad();
        EMenu.getInstance();
    }
}
