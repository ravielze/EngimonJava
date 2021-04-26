package com.engimon.menu.beginning;

import com.engimon.entity.Cheat;
import com.engimon.entity.Game;
import com.engimon.entity.engimon.Engimon;
import com.engimon.menu.EMenu;
import com.engimon.menu.component.EButton;

import java.awt.event.*;

public class EngimonPicker extends EButton {

    public EngimonPicker(Engimon eng) {
        super(eng.getName(), 20, new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Game.create(eng);
                if (Game.getRunningGame() != null) {
                    Game.getRunningGame().getPlayer().addEngimon(Cheat.getSecondEngimon());
                    Game.getRunningGame().getPlayer().addEngimon(Cheat.getThirdEngimon());
                }
                
                EMenu.getInstance().changePage(EMenu.MAIN_PAGE);
            }
        });
    }

    public EngimonPicker(String eng) {
        super(eng, 20, new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(eng);
            }
        });
    }
}