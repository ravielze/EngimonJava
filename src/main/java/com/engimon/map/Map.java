package com.engimon.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.SecureRandom;

import com.engimon.exception.CellException;
import com.engimon.exception.CellException.ErrorCause;
import com.engimon.map.biome.Cell;
import com.engimon.map.biome.cells.GrasslandCell;
import com.engimon.map.biome.cells.MountainCell;
import com.engimon.map.biome.cells.PowerplantCell;
import com.engimon.map.biome.cells.SeaCell;
import com.engimon.map.biome.cells.TundraCell;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class Map implements Serializable {

    private static final long serialVersionUID = -7776475252062247238L;
    private final static int MAP_DEFAULT_SIZE = 30;
    private static Map instance;
    private Table<Integer, Integer, Cell> storage;
    private int size;

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map(MAP_DEFAULT_SIZE);
        }
        return instance;
    }

    public static void setInstance(Map map) {
        instance = map;
    }

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

    public Map() {
        // Constructor for Serializable Access
    }

    // TODO populate tree and rock
    public Map(int size) {
        this.size = size;
        this.storage = TreeBasedTable.create();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                storage.put(x, y, new GrasslandCell(x, y));
            }
        }
        massPopulate(MountainCell.class, 4, 3, 0.45D);
        massPopulate(SeaCell.class, 5, 4, 0.3D);
        massPopulate(TundraCell.class, 4, 3, 0.4D);
        massPopulate(PowerplantCell.class, 4, 3, 0.45D);
    }

    synchronized public Cell getCell(int x, int y) throws CellException {
        if (!isInRange(x, y))
            throw new CellException(ErrorCause.CELL_NOT_FOUND);
        return storage.get(x, y);
    }

    public Cell[] getTwoSpawnableCell() {
        SecureRandom sr = new SecureRandom();
        int x = sr.nextInt(this.size);
        int y = sr.nextInt(this.size);
        Cell playerCell;
        Cell engiCell;
        while (true) {
            try {
                playerCell = getCell(x, y);
                int delta = populateRandomSpread(sr);
                int choice = sr.nextInt(2);
                if (choice == 1) {
                    engiCell = getCell(x + delta, y);
                } else {
                    engiCell = getCell(x, y + delta);
                }
                if (!playerCell.isOccupied() && !engiCell.isOccupied()) {
                    return new Cell[] { playerCell, engiCell };
                }
            } catch (CellException notFoundIgnored) {
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean isInRange(int x, int y) {
        return (x >= 0 && x < size && y >= 0 && y < size);
    }

    private void massPopulate(Class<? extends Cell> clazz, int triesPerVein, int vein, double chance) {
        SecureRandom sr = new SecureRandom();
        for (int v = 0; v < vein; v++) {
            int x = sr.nextInt(size);
            int y = sr.nextInt(size);
            for (int t = 0; t < triesPerVein; t++) {
                populate(sr, clazz, x, y, chance);
                x += populateRandomSpread(sr);
                y += populateRandomSpread(sr);
            }
        }
    }

    private int populateRandomSpread(SecureRandom sr) {
        int result = 0;
        do {
            result = sr.nextInt(3) - 1;
        } while (result == 0);
        return result;
    }

    private void populate(SecureRandom sr, Class<? extends Cell> clazz, int x, int y, double chance) {
        try {
            storage.put(x, y, clazz.getConstructor(Integer.class, Integer.class).newInstance(x, y));
        } catch (Exception ignored) {
        }
        for (int rx = -1; rx <= 1; rx++) {
            for (int ry = -1; ry <= 1; ry++) {
                if (!isInRange(x + rx, y + ry))
                    continue;
                if (sr.nextDouble() < chance) {
                    try {
                        storage.put(x + rx, y + ry,
                                clazz.getConstructor(Integer.class, Integer.class).newInstance(x + rx, y + ry));
                    } catch (Exception ignored) {
                    }
                }
            }
        }
    }

}
