package com.engimon.map.biome.cells;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.engimon.common.ResourceReader;
import com.engimon.entity.engimon.Elementum;
import com.engimon.entity.enums.Element;
import com.engimon.map.biome.Cell;

public class MountainCell extends Cell implements Serializable {

    private static final long serialVersionUID = 3488408262249655249L;
    private static final Image IMAGE = ResourceReader.getImage("Images/Others/MapTerrain/mountain.png", 24, 24);

    public MountainCell(Integer x, Integer y) {
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
        return Color.decode("#663800");
    }

    @Override
    public Image getSprite() {
        return MountainCell.IMAGE;
    }

    @Override
    public String toString() {
        return "{MT : " + ((this.getOccupier() == null) ? "NULL" : this.getOccupier().toString()) + "}";
    }
}
