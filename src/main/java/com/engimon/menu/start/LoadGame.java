package com.engimon.menu.start;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.engimon.entity.Game;
import com.engimon.menu.EMenu;
import com.engimon.menu.component.EButton;

public class LoadGame extends EButton {

    public LoadGame() {
        super("Load Game", 20, 150, 60, new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Game.load();
                EMenu.MAIN_PAGE.update();
                EMenu.getInstance().changePage(EMenu.MAIN_PAGE);
            }
        });
        setBackground(new Color(201, 226, 101));
    }

}
