package com.engimon.map.biome.cells;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.engimon.entity.engimon.Elementum;
import com.engimon.entity.enums.Element;
import com.engimon.map.biome.Cell;

public class SeaCell extends Cell {

    private static final long serialVersionUID = -3167859968279015012L;

    public SeaCell(Integer x, Integer y) {
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

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

    @Override
    public Color getColor() {
        return Color.decode("#00c3ff");

    }

}
