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
        
        add(placeholder);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        if (cell.isOccupied()) {
            System.out.printf("Cell {%d, %d} is occupied by %s\n", cell.getX(), cell.getY(), cell.getOccupier());
            placeholder.setBorder(BorderFactory.createLineBorder(Color.BLACK, padding));
            return;
        }
        placeholder.setBorder(BorderFactory.createLineBorder(cell.getColor(), padding));

    }
}
