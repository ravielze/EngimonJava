package com.engimon.menu.view_engimon;

import java.awt.Color;

import javax.swing.JPanel;

import com.engimon.entity.skill.Skill;
import com.engimon.menu.component.ECard;
import com.engimon.menu.component.ERow;

public class SkillDetails extends JPanel{
    public SkillDetails(Skill skill) {
        ERow row = new ERow();
        
        // TODO add image before label
        row.add(new ECard(skill.toString(), Color.decode("#ff00ae")));

        add(row);
    }
}
