package com.engimon.menu.start;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.engimon.menu.EMenu;
import com.engimon.menu.component.EButton;

public class NewGame extends EButton {

    public NewGame() {
        super("New Game", 20, 150, 60, new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                EMenu.getInstance().changePage(EMenu.BEGINNING_PAGE);
            }
        });
        setBackground(new Color(201, 226, 101));
    }

}
