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

public class GrasslandCell extends Cell {

    private static final long serialVersionUID = 4976989679027883563L;
    private static final Image IMAGE = ResourceReader.getImage("Images/Others/MapTerrain/grassland.png", 24, 24);

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

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

    @Override
    public Color getColor() {
        return Color.decode("#32a600");
    }

    @Override
    public Image getSprite() {
        return GrasslandCell.IMAGE;
    }
}
