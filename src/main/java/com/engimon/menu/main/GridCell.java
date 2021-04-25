package com.engimon.menu.main;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.*;
import com.engimon.map.biome.Cell;



import com.engimon.menu.EComponent;

public class GridCell extends EComponent {
    private JLabel placeholder;
    private final int padding = 10;

    public <T extends Cell> GridCell(T cell) {
        this.placeholder = new JLabel("");
        
        placeholder.setBorder(BorderFactory.createLineBorder(cell.getColor(), padding));
        add(placeholder);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
