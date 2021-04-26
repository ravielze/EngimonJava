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

public class PowerplantCell extends Cell {

    private static final long serialVersionUID = -6222841280611348432L;
    private static final Image IMAGE = ResourceReader.getImage("Images/Others/MapTerrain/powerplant.png", 24, 24);

    public PowerplantCell(Integer x, Integer y) {
        super(x, y);
    }

    public PowerplantCell() {
        super();
        // Constructor for Serializable Access
    }

    @Override
    public Color getColor() {
        return Color.decode("#7f00ff");
    }

    @Override
    protected boolean allowPass(Elementum el) {
        return el.isOneOf(Element.ELECTRIC);
    }

    @Override
    public Image getSprite() {
        return PowerplantCell.IMAGE;
    }

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

}
