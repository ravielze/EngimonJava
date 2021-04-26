package com.engimon.map.biome.cells;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.engimon.common.ResourceReader;
import com.engimon.entity.engimon.Elementum;
import com.engimon.entity.enums.Element;
import com.engimon.map.biome.Cell;

public class TundraCell extends Cell {

    private static final long serialVersionUID = -4675737389227767603L;
    private static final Image IMAGE = ResourceReader.getImage("Images/Others/MapTerrain/tundra.png", 24, 24);

    public TundraCell() {
        super();
        // Constructor for Serializable Access
    }

    public TundraCell(int x, int y) {
        super(x, y);
    }

    @Override
    protected boolean allowPass(Elementum el) {
        return el.isOneOf(Element.ICE);
    }

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

    @Override
    public Color getColor() {
        return Color.decode("#ffb300");
    }

    @Override
    public Image getSprite() {
        return TundraCell.IMAGE;
    }

}
