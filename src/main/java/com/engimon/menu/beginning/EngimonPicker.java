package com.engimon.menu.beginning;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.engimon.entity.Cheat;
import com.engimon.entity.Game;
import com.engimon.entity.engimon.Engimon;
import com.engimon.menu.EMenu;
import com.engimon.menu.component.EButtonFactory;
import com.engimon.menu.component.EColumn;
import com.engimon.menu.component.EImage;

public class EngimonPicker extends JPanel {

    public EngimonPicker(Engimon eng) {
        EColumn column = new EColumn();
        column.add(EButtonFactory.CreateDefaultFontButton(eng.getName(), Color.decode("#03ffd9"), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Game.create(eng);
                Cheat.IncreaseExpBy(2000);
                EMenu.getInstance().changePage(EMenu.MAIN_PAGE);
            }
        }));
        column.add(new EImage(eng.getIcon(), 100, 100));
        add(column);
    }

    public EngimonPicker(String eng) {

        add(EButtonFactory.CreateDefaultFontButton(eng, Color.decode("#03ffd9"), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        }));
    }
}