package com.engimon.map.biome;

import com.engimon.entity.Element;
import com.engimon.entity.Elementum;

public class GrasslandCell extends Cell {

    @Override
    protected boolean allowPass(Elementum el) {
        return el.isOneOf(Element.GROUND) || el.isOneOf(Element.ELECTRIC);
    }

}
