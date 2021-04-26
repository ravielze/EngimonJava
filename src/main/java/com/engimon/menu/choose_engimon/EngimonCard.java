package com.engimon.menu.choose_engimon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.engimon.inventory.Storable;
import com.engimon.menu.EComponent;
import com.engimon.menu.component.ERow;

public class EngimonCard extends JPanel implements EComponent{
    public EngimonCard(Storable en) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        ERow row = new ERow();
        row.justifyFlexStart();
        row.setPreferredSize(new Dimension(400,100));
        
        // TODO : add engimon image before label

        JLabel label = new JLabel(en.toString());
        label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        row.add(label);
        
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        row.setBackground(Color.decode("#dbdbdb"));
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        add(row);
    }

    public void setPick() {
        setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    public void setUnPick() {
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
}
