package com.engimon.map.biome.cells;

import com.engimon.entity.engimon.Elementum;
import com.engimon.entity.enums.Element;
import com.engimon.map.biome.Cell;

public class GrasslandCell extends Cell {

    private static final long serialVersionUID = 4976989679027883563L;

    public GrasslandCell(int x, int y) {
        super(x, y);
    }

    public GrasslandCell() {
        super();
        // Constructor for Serializable Access
    }

    @Override
    protected boolean allowPass(Elementum el) {
        return el.isOneOf(Element.GROUND) || el.isOneOf(Element.ELECTRIC);
    }

}
