package com.engimon.map.biome.cells;

import com.engimon.entity.engimon.Elementum;
import com.engimon.entity.enums.Element;
import com.engimon.map.biome.Cell;

public class SeaCell extends Cell {

    private static final long serialVersionUID = -3167859968279015012L;

    public SeaCell(int x, int y) {
        super(x, y);
    }

    public SeaCell() {
        super();
        // Constructor for Serializable Access
    }

    @Override
    protected boolean allowPass(Elementum el) {
        return el.isOneOf(Element.WATER);
    }

}
