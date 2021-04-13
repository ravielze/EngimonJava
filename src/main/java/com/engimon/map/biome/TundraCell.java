package com.engimon.map.biome;

import com.engimon.entity.Element;
import com.engimon.entity.Elementum;

public class TundraCell extends Cell {

    @Override
    protected boolean allowPass(Elementum el) {
        return el.isOneOf(Element.ICE);
    }

}
