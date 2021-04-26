package com.engimon.map.biome.cells;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

    @Override
    public Color getColor() {
        // TODO Auto-generated method stub
        return Color.decode("#663800");
    }

    @Override
    public Image getSprite() {
        // TODO Auto-generated method stub
        return null;
    }

}
