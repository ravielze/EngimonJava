package com.engimon.map.biome;

import com.engimon.entity.Element;
import com.engimon.entity.Elementum;

public class SeaCell extends Cell {

    public SeaCell(int x, int y) {
        super(x, y);
    }

    @Override
    protected boolean allowPass(Elementum el) {
        return el.isOneOf(Element.WATER);
    }

}
