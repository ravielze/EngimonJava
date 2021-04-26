package com.engimon.menu.main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.engimon.entity.Player;
import com.engimon.map.biome.Cell;
import com.engimon.menu.EComponent;
import com.engimon.menu.component.EImage;

public class GridCell extends JPanel implements EComponent {

    public GridCell(Cell cell) {
        setSize(24, 24);
        setPreferredSize(new Dimension(24, 24));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        if (cell.isOccupied()) {
            System.out.printf("Cell {%d, %d} is occupied by %s\n", cell.getX(), cell.getY(), cell.getOccupier());
            if (cell.getOccupier() instanceof Player) {
                add(new EImage("Images/Others/player_sprite-min.png", 24, 24));
            } else {
                setBackground(Color.BLACK);
            }
            return;
        }
        add(new EImage(cell.getSprite(), 24, 24));

    }
}
