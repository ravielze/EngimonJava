package com.engimon.menu.breeding;

import com.engimon.entity.engimon.Engimon;
import com.engimon.menu.EPage;
import com.engimon.menu.component.EImage;
import com.engimon.menu.component.ERow;

public class Breeding extends EPage {
    private Engimon firstEngimon;
    private Engimon secondEngimon;
    public Breeding(Engimon firstEngimon, Engimon secondEngimon) {
        this.firstEngimon = firstEngimon;
        this.secondEngimon = secondEngimon;

        update();
    }

    @Override
    public void update() {
        removeAll();
        // TODO Auto-generated method stub
        ERow firstParentRow = new ERow();
        // TODO : Add first parent image before breeding stats
        firstParentRow.add(new BreedingStats(firstEngimon));
        add(firstParentRow);

        EImage love = new EImage("Images/Others/Icon/heart_icon (for breeding)-min.png", 200, 100);
        add(love);

        ERow secondParentRow = new ERow();
        secondParentRow.add(new BreedingStats(secondEngimon));
        // TODO : Add second parent image after breeding stats
        add(secondParentRow);



    }
}
