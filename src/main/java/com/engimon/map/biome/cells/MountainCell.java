package com.engimon.map.biome.cells;

import com.engimon.entity.engimon.Elementum;
import com.engimon.entity.enums.Element;
import com.engimon.map.biome.Cell;

public class MountainCell extends Cell {

    private static final long serialVersionUID = 3488408262249655249L;

    public MountainCell(int x, int y) {
        super(x, y);
    }

    public MountainCell() {
        super();
        // Constructor for Serializable Access
    }

    @Override
    protected boolean allowPass(Elementum el) {
        return el.isOneOf(Element.FIRE);
    }

}
