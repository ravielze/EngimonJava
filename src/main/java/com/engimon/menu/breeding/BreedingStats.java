package com.engimon.menu.breeding;


import java.awt.Color;


import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.skill.Skill;
import com.engimon.menu.component.ECard;
import com.engimon.menu.component.EColumn;

public class BreedingStats extends EColumn {
    public BreedingStats(Engimon e) {
        String textToShow = "";
        
        textToShow += e.toString() + "\n";
        textToShow += "Skills : \n";
        for (Skill skill : e.getAllSkills()) {
            textToShow += skill.toString() + "\n";
        }
        add(new ECard(textToShow, Color.decode("#7dff81")));
    }
    
}
