package com.engimon.menu.main;

import javax.swing.JPanel;

import com.engimon.exception.CellException;
import com.engimon.map.Map;
import com.engimon.map.biome.Cell;
import com.engimon.menu.EComponent;
import com.engimon.menu.component.EColumn;
import com.engimon.menu.component.ERow;

public class MapGrid extends JPanel implements EComponent {
    public MapGrid(Map map) {
        EColumn column = new EColumn();
        for (int y = 0; y < map.getSize(); y++) {
            ERow row = new ERow();
            for (int x = 0; x < map.getSize(); x++) {
                try {
                    Cell cell = map.getCell(x, y);
                    row.add(new GridCell(cell));

                } catch (CellException e) {

                }
            }
            column.add(row);
        }
        add(column);
    }
}
