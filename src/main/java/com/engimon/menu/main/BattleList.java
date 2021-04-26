package com.engimon.menu.main;

import java.awt.Color;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.engimon.entity.Game;
import com.engimon.entity.Player;
import com.engimon.entity.engimon.WildEngimon;
import com.engimon.menu.EMenu;
import com.engimon.menu.battle.Battle;
import com.engimon.menu.component.EButtonFactory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleList extends JPanel {
    public BattleList(List<WildEngimon> wildEngimon) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        wildEngimon.forEach(wild -> {
            add(EButtonFactory.CreateDefaultFontButton(wild.getName(), Color.decode("#fcff5e"), new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Player player = Game.getRunningGame().getPlayer();
                    EMenu.getInstance().changePage(new Battle(player.getActiveEngimon(), wild));
                }
            }));
        });
    }
}
