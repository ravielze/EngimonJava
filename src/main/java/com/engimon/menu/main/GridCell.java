package com.engimon.menu.main;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.engimon.entity.Player;
import com.engimon.entity.engimon.Engimon;
import com.engimon.map.biome.Cell;
import com.engimon.menu.EComponent;
import com.engimon.menu.component.EImage;
import com.engimon.menu.component.EStackedImage;

public class GridCell extends JPanel implements EComponent {

    public GridCell(Cell cell) {
        setSize(24, 24);
        setPreferredSize(new Dimension(24, 24));
        if (cell.isOccupied()) {
            ArrayList<EImage> images = new ArrayList<EImage>(2);
            if (cell.getOccupier() instanceof Player) {
                images.add(new EImage("Images/Others/player_sprite-min.png", 24, 24));
            } else if (cell.getOccupier() instanceof Engimon) {
                images.add(new EImage(((Engimon) cell.getOccupier()).getSprite(), 24, 24));
            }
            images.add(new EImage(cell.getSprite(), 24, 24));
            add(new EStackedImage(images, 24, 24));
            return;
        }
        add(new EImage(cell.getSprite(), 24, 24));

    }
}
