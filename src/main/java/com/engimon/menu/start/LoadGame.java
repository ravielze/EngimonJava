package com.engimon.menu.start;

import java.awt.event.*;

import com.engimon.entity.Game;
import com.engimon.menu.EMenu;
import com.engimon.menu.component.EButton;

public class LoadGame extends EButton {

    public LoadGame() {
        super(EMenu.START_PAGE, "Load Game", new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Game.load();
                // TODO change to map
            }
        });
    }

}
