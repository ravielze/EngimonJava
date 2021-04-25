package com.engimon.menu.beginning;

import com.engimon.entity.Game;
import com.engimon.entity.engimon.Engimon;
import com.engimon.menu.EMenu;
import com.engimon.menu.component.EButton;

import java.awt.event.*;

public class EngimonPicker extends EButton {

    public EngimonPicker(Engimon eng) {
        super(EMenu.BEGINNING_PAGE, eng.getName(), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Game.create(eng);
            }
        });
    }
}