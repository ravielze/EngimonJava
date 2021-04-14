package com.engimon.entity;

import com.engimon.entity.enums.Element;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class ElementTable {

    private Table<Element, Element, Double> data = HashBasedTable.create();
    {
        data.put(Element.FIRE, Element.WATER, 2D);
        data.put(Element.FIRE, Element.ELECTRIC, 1D);
        data.put(Element.FIRE, Element.GROUND, 1.5D);
        data.put(Element.FIRE, Element.ICE, 0D);

        data.put(Element.WATER, Element.FIRE, 0D);
        data.put(Element.WATER, Element.ELECTRIC, 2D);
        data.put(Element.WATER, Element.GROUND, 1D);
        data.put(Element.WATER, Element.ICE, 1D);

        data.put(Element.ELECTRIC, Element.FIRE, 1D);
        data.put(Element.ELECTRIC, Element.WATER, 0D);
        data.put(Element.ELECTRIC, Element.GROUND, 2D);
        data.put(Element.ELECTRIC, Element.ICE, 0.5D);

        data.put(Element.GROUND, Element.FIRE, 0.5D);
        data.put(Element.GROUND, Element.WATER, 1D);
        data.put(Element.GROUND, Element.ELECTRIC, 0D);
        data.put(Element.GROUND, Element.ICE, 2D);

        data.put(Element.ICE, Element.FIRE, 2D);
        data.put(Element.ICE, Element.WATER, 1D);
        data.put(Element.ICE, Element.ELECTRIC, 1.5D);
        data.put(Element.ICE, Element.GROUND, 0D);
    }

    private static ElementTable instance;

    public static double getMultiplier(Element attack, Element defense) {
        if (instance == null) {
            instance = new ElementTable();
        }
        return instance.getMult(attack, defense);
    }

    private double getMult(Element attack, Element defense) {
        if (attack == Element.NONE || defense == Element.NONE)
            return 0D;
        if (attack == defense)
            return 1D;
        Double result = data.get(defense, attack);
        if (result == null) {
            return 2D - data.get(attack, defense);
        }
        return result;
    }

}
