package com.engimon.menu.main;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.engimon.entity.Player;
import com.engimon.entity.engimon.Engimon;
import com.engimon.map.biome.Cell;
import com.engimon.menu.EComponent;
import com.engimon.menu.component.EColumn;
import com.engimon.menu.component.EImage;
import com.engimon.menu.component.ERow;

public class GridCell extends JPanel implements EComponent {

    public GridCell(Cell cell) {
        setSize(24, 24);
        setPreferredSize(new Dimension(24, 24));
        // this.setBorder(BorderFactory.createLineBorder(Color.black));
        if (cell.isOccupied()) {
            if (cell.getOccupier() instanceof Player) {
                add(new EImage("Images/Others/player_sprite-min.png", 20, 20));
            } else if (cell.getOccupier() instanceof Engimon) {
                EColumn row = new EColumn();
                row.add(new EImage(((Engimon) cell.getOccupier()).getSprite(), 16, 16));
                add(row);
            }
            return;
        }
        add(new EImage(cell.getSprite(), 24, 24));

    }
}
