package com.engimon.menu.view_engimon;

import java.awt.Color;

import javax.swing.JPanel;

import com.engimon.entity.skill.Skill;
import com.engimon.menu.component.ECard;
import com.engimon.menu.component.EImage;
import com.engimon.menu.component.ERow;

public class SkillDetails extends JPanel{
    public SkillDetails(Skill skill) {
        ERow row = new ERow();
        row.justifyFlexStart();
        // TODO add image before label
        row.setBackground(Color.decode("#faa1ff"));
        row.add(new EImage(skill.getSkillIcon(), 40, 40));
        row.add(new ECard(skill.toString(), Color.decode("#faa1ff")));

        add(row);
    }
}
