package com.engimon.menu.choose_engimon;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.engimon.inventory.Storable;
import com.engimon.menu.EComponent;
import com.engimon.menu.component.ECard;
import com.engimon.menu.component.ERow;

public class EngimonCard extends JPanel implements EComponent{
    public EngimonCard(Storable en) {
        ERow row = new ERow();
        row.justifyFlexStart();
        
        // TODO : add engimon image before label

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // setPreferredSize(new Dimension(200,80));
        row.add(new ECard(en.toString() ,Color.decode("#dbdbdb")));
        add(row);
    }

    public void setPick() {
        setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    public void setUnPick() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
