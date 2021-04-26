package com.engimon.menu.view_engimon;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.engimon.entity.engimon.Engimon;
import com.engimon.menu.EPage;
import com.engimon.menu.component.ECard;
import com.engimon.menu.component.EColumn;
import java.awt.GridLayout;


public class ViewEngimon extends EPage {

    private Engimon engimon;

    public ViewEngimon(Engimon en) {
        engimon = en;
        update();
    }

    @Override
    public void update() {
        // TODO add image
        removeAll();
        EColumn column = new EColumn();
        column.setOpaque(true);
        column.setBackground(Color.decode("#00f7ff"));
        column.setBorder(BorderFactory.createLineBorder(Color.decode("#00f7ff"), 20));

        column.add(new JLabel(engimon.getName()));
        column.add(new ECard(engimon.toString(), Color.decode("#d400ff")));

        JPanel skillContainer = new JPanel(new GridLayout(2,2));

        engimon.getAllSkills().forEach(skill -> skillContainer.add(new SkillDetails(skill)));

        column.add(skillContainer);

        add(column);
    }
    
}
