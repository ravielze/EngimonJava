package com.engimon.menu.battle;

import javax.swing.JPanel;

import com.engimon.entity.engimon.Engimon;
import com.engimon.menu.EPage;
import com.engimon.menu.component.ERow;
import com.engimon.menu.component.ETitle;

public class Battle extends EPage {
    private Engimon ourEngimon;
    private Engimon wildEngimon;
    public Battle(Engimon ourEgimon, Engimon wildEngimon) {
        this.ourEngimon = ourEgimon;
        this.wildEngimon = wildEngimon;
    }
    @Override
    public void update() {
        add(new ETitle("Battle"));
        ERow firstRow = new ERow();
        ERow secondRow = new ERow();


        add(firstRow);
        add(secondRow);
    }

    private JPanel battleStats(Engimon e) {
        
    }
    
}
