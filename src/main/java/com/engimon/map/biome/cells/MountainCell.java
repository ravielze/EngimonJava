package com.engimon.map.biome.cells;

import com.engimon.entity.engimon.Elementum;
import com.engimon.entity.enums.Element;
import com.engimon.map.biome.Cell;

public class MountainCell extends Cell {

    public MountainCell(int x, int y) {
        super(x, y);
    }

    @Override
    protected boolean allowPass(Elementum el) {
        return el.isOneOf(Element.FIRE);
    }

}
