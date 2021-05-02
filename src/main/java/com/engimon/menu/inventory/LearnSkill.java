package com.engimon.menu.inventory;

import javax.swing.JOptionPane;

import com.engimon.entity.Game;
import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.skill.SkillItem;
import com.engimon.exception.EngimonStateException;
import com.engimon.exception.SkillItemExpired;
import com.engimon.menu.EMenu;
import com.engimon.menu.choose_engimon.ChooseEngimon;
import com.engimon.menu.choose_engimon.EngimonCard;
import com.engimon.menu.component.EBack;

public class LearnSkill extends ChooseEngimon {
    private SkillItem skillItem;

    public LearnSkill(SkillItem skillItem) {
        super(ChooseMode.ENGIMON);
        this.skillItem = skillItem;
    }

    @Override
    public void chooseEngimon(Engimon e, EngimonCard ec) {
        // TODO Auto-generated method stub
        try {
            skillItem.learn(e);
            EMenu.getInstance().changePage(EMenu.MAIN_PAGE);
        } catch (EngimonStateException er) {
            JOptionPane.showMessageDialog(this, String.format("%s cant't learn that skill", e.getName()), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SkillItemExpired se) {
            // TODO
            Game.getRunningGame().getPlayer().removeItem(se.getSkillItem());
        }
    }

    @Override
    public void chooseSkillItem(SkillItem e, EngimonCard ec) {
        // TODO Auto-generated method stub

    }
    @Override
    public void update() {
        // TODO Auto-generated method stub
        super.update();
        add(new EBack());
    }
}
