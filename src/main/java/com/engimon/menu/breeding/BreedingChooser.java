package com.engimon.menu.breeding;

import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.skill.SkillItem;
import com.engimon.menu.EMenu;
import com.engimon.menu.choose_engimon.ChooseEngimon;
import com.engimon.menu.choose_engimon.EngimonCard;
import com.engimon.menu.component.EButtonFactory;
import com.engimon.menu.component.ERow;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BreedingChooser extends ChooseEngimon {

    public BreedingChooser() {
        super(ChooseMode.ENGIMON);
        update();
    }

    @Override
    public void update() {
        super.update();
        ERow row = new ERow();
        row.add(EButtonFactory.CreateDefaultFontButton("Clear", Color.decode("#0aceff") , 200, 80,new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                restart();
            }
        }));
        
        row.add(EButtonFactory.CreateDefaultFontButton("Confirm", Color.decode("#12c91b"), 200, 80, new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (firstEngimon == null || secondEngimon == null) return;
                EMenu.getInstance().changePage(new Breeding(firstEngimon, secondEngimon));
            }
        }));
        add(row);
    }

    private Engimon firstEngimon = null;
    private Engimon secondEngimon = null;

    private EngimonCard firstCard = null;
    private EngimonCard secondCard = null;

    private void restart() {
        if (firstEngimon != null) {
            firstCard.setUnPick();
            firstEngimon = null;
            firstCard = null;
        }
        if (secondEngimon != null) {
            secondCard.setUnPick();
            secondEngimon = null;
            secondCard = null;
        }

    }

    @Override
    public void chooseEngimon(Engimon e, EngimonCard ec) {
        if (firstEngimon == null) {
            firstEngimon = e;
            firstCard = ec;
            firstCard.setPick();
            return;
        }
        if (secondEngimon == null) {
            secondEngimon = e;
            secondCard = ec;
            secondCard.setPick();
            return;
        }
    }

    @Override
    public void chooseSkillItem(SkillItem e, EngimonCard ec) {
        // TODO Auto-generated method stub
        
    }
}
