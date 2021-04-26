package com.engimon.menu.battle;

import javax.swing.Box;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import com.engimon.entity.Game;
import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.WildEngimon;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.InventoryFull;
import com.engimon.menu.EMenu;
import com.engimon.menu.EPage;
import com.engimon.menu.component.EImage;
import com.engimon.menu.component.ERow;
import com.engimon.menu.component.ETitle;
import com.engimon.menu.component.EButtonFactory;
import com.engimon.menu.component.ECard;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Battle extends EPage {
    private Engimon ourEngimon;
    private WildEngimon wildEngimon;

    public Battle(Engimon ourEgimon, WildEngimon wildEngimon) {
        this.ourEngimon = ourEgimon;
        this.wildEngimon = wildEngimon;
    }

    @Override
    public void update() {
        add(new ETitle("Battle"));
        ERow firstRow = new ERow();
        ERow secondRow = new ERow();
        ERow thirdRow = new ERow();
        firstRow.add(battleStats(ourEngimon, wildEngimon));
        firstRow.add(Box.createRigidArea(new Dimension(20, 0)));
        firstRow.add(new EImage(ourEngimon.getIcon(), 80, 80));

        secondRow.add(new EImage(wildEngimon.getIcon(), 80, 80));
        secondRow.add(Box.createRigidArea(new Dimension(20, 0)));
        secondRow.add(battleStats(wildEngimon, ourEngimon));

        thirdRow.add(
                EButtonFactory.CreateDefaultFontButton("Proceed Battle", Color.decode("#fcff5e"), new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Game.getRunningGame().getPlayer().battle(wildEngimon);
                            EMenu.getInstance().changePage(EMenu.MAIN_PAGE);
                        } catch (InventoryFull er) {

                        } catch (Exception er) {

                        }
                    }
                }));
        thirdRow.add(Box.createRigidArea(new Dimension(30, 0)));
        thirdRow.add(
                EButtonFactory.CreateDefaultFontButton("Cancel Battle", Color.decode("#fcff5e"), new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        EMenu.getInstance().changePage(EMenu.MAIN_PAGE);
                    }
                }));

        add(firstRow);
        add(secondRow);
        add(thirdRow);
    }

    private JPanel battleStats(Engimon attacker, Engimon defender) {
        String text = "";

        text += attacker.getName() + "\n";
        text += "Skills : \n";
        for (Skill skill : attacker.getAllSkills()) {
            text += skill.toString() + "\n";
        }

        text += "Power level : " + (int) attacker.getPower(defender);

        return new ECard(text, Color.decode("#fcff5e"));
    }

}
