package com.engimon.menu.start;

import java.awt.event.*;

import com.engimon.menu.EMenu;
import com.engimon.menu.component.EButton;

public class NewGame extends EButton {

    public NewGame() {
        super(EMenu.START_PAGE, "New Game", new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                EMenu.getInstance().changePage(EMenu.BEGINNING_PAGE);
            }
        });
    }

}
