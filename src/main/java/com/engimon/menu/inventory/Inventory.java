package com.engimon.menu.inventory;

import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.skill.SkillItem;
import com.engimon.menu.EMenu;
import com.engimon.menu.choose_engimon.ChooseEngimon;
import com.engimon.menu.choose_engimon.EngimonCard;
import com.engimon.menu.component.EButton;
import com.engimon.menu.component.EButtonFactory;
import com.engimon.menu.component.ERow;
import com.engimon.menu.view_engimon.ViewEngimon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;

import java.awt.Color;

public class Inventory extends ChooseEngimon {


    private EButton engimonTab;
    private EButton skillTab;
    private ChooseMode mode  = ChooseMode.ENGIMON;
    public Inventory() {
        super(ChooseMode.ENGIMON);
        skillTab.setBorder(BorderFactory.createLineBorder(Color.RED));
        engimonTab = EButtonFactory.CreateDefaultFontButton("Engimon", Color.decode("#0aceff"), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mode = ChooseMode.ENGIMON;
                engimonTab.setBorder(BorderFactory.createLineBorder(Color.RED));
                skillTab.setBorder(BorderFactory.createEmptyBorder());
                update();
            }
        });
        engimonTab.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        skillTab = EButtonFactory.CreateDefaultFontButton("Skill", Color.decode("#0aceff"), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mode = ChooseMode.SKILLITEM;
                skillTab.setBorder(BorderFactory.createLineBorder(Color.RED));
                engimonTab.setBorder(BorderFactory.createEmptyBorder());
                update();
            }
        });
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        ERow tab = new ERow();
        if (engimonTab != null && skillTab != null) {
            tab.add(engimonTab);
            tab.add(skillTab);
        }
        // add(tab);
        setMode(mode);
        super.update();
        add(tab, 0);
    }

    @Override
    public void chooseEngimon(Engimon e, EngimonCard ec) {
        // TODO Auto-generated method stub
        EMenu.getInstance().changePage(new ViewEngimon(e));
    }

    @Override
    public void chooseSkillItem(SkillItem e, EngimonCard ec) {
        // TODO Auto-generated method stub
        System.out.println(e);
        
    }
    
}
