package com.engimon.menu.view_engimon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.engimon.entity.engimon.Engimon;
import com.engimon.menu.EPage;
import com.engimon.menu.component.EBack;
import com.engimon.menu.component.ECard;
import com.engimon.menu.component.EColumn;
import com.engimon.menu.component.EImage;
import com.engimon.menu.component.EStackedImage;

import java.awt.GridLayout;
import java.util.ArrayList;


public class ViewEngimon extends EPage {

    private Engimon engimon;

    public ViewEngimon(Engimon en) {
        engimon = en;
        update();
    }

    @Override
    public void update() {
        removeAll();
        EColumn column = new EColumn();
        column.setBackground(Color.decode("#00f7ff"));
        column.add(engimonImage());
        column.add(engimonName());
        column.add(engimonDetails());
        column.add(skillText());
        JPanel skillContainer = new JPanel(new GridLayout(2,2));
        engimon.getAllSkills().forEach(skill -> skillContainer.add(new SkillDetails(skill)));
        column.add(skillContainer);
        column.add(new EBack());
        add(column);
    }
    private JPanel engimonDetails() {
        ECard card = new ECard(engimon.toString(), Color.decode("#aa96ff"));
        card.setPreferredSize(new Dimension(300, 120));
        return card;
    }
    private JLabel skillText() {
        JLabel skill = new JLabel("Skills : ");
        skill.setFont(new Font("Arial", Font.PLAIN, 24));
        return skill;
    }
    private JLabel engimonName() {
        JLabel name = new JLabel("Name : " + engimon.getName());
        name.setFont(new Font("Arial", Font.PLAIN, 16));
        return name;
    }

    private JLayeredPane engimonImage() {
        ArrayList<EImage> images = new ArrayList<EImage>(2);
        images.add(new EImage(engimon.getIcon(), 200, 200));
        images.add(new EImage(engimon.getAura(), 200, 200));
        return new EStackedImage(images, 200, 200);
        
    }
    
}
