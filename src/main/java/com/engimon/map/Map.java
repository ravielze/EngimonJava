package com.engimon.map;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.engimon.entity.engimon.WildEngimon;
import com.engimon.exception.CellException;
import com.engimon.exception.CellException.ErrorCause;
import com.engimon.map.biome.Cell;
import com.engimon.map.biome.CellOccupier;
import com.engimon.map.biome.cells.CaveCell;
import com.engimon.map.biome.cells.GrasslandCell;
import com.engimon.map.biome.cells.MountainCell;
import com.engimon.map.biome.cells.PowerplantCell;
import com.engimon.map.biome.cells.SeaCell;
import com.engimon.map.biome.cells.TundraCell;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class Map implements Serializable {

    private static final long serialVersionUID = -7776475252062247238L;
    private final static int MAP_DEFAULT_SIZE = 30;
    private static Map instance;
    private Table<Integer, Integer, Cell> storage;
    private int size;

    public synchronized static Map getInstance() {
        if (instance == null) {
            try {
                instance = new Map("map.txt");
            } catch (IOException | IllegalStateException | NoSuchElementException ex) {
                instance = new Map(MAP_DEFAULT_SIZE);
            }
        }
        return instance;
    }

    public synchronized static void setInstance(Map map) {
        instance = map;
    }

    public static Table<Integer, Integer, Serializable> wrap(Map map) {
        Table<Integer, Integer, Serializable> result = HashBasedTable.create();
        try {
            for (int i = 0; i < map.getSize(); i++) {
                for (int j = 0; j < map.getSize(); j++) {
                    if (map.getCell(i, j).isOccupied()) {
                        CellOccupier ent = map.getCell(i, j).getOccupier();
                        if (ent instanceof Serializable) {
                            result.put(i, j, (Serializable) ent);
                        }
                    }
                }
            }
        } catch (CellException ignored) {
            ignored.printStackTrace();
        }
        return result;
    }

    public static void unwrap(Map map, Table<Integer, Integer, Serializable> bungkus) {
        try {
            for (int i = 0; i < map.getSize(); i++) {
                for (int j = 0; j < map.getSize(); j++) {
                    Serializable x = bungkus.get(i, j);
                    if (x != null) {
                        if (x instanceof CellOccupier) {
                            CellOccupier ent = (CellOccupier) x;
                            map.getCell(i, j).setOccupier(ent);
                        }
                    }
                }
            }
        } catch (CellException ignored) {
            ignored.printStackTrace();
        }
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

    public Map(String fileName) throws IOException, IllegalStateException, NoSuchElementException {
        Scanner reader = new Scanner(System.in);
        try {
            File f = new File(fileName);
            reader.close();
            reader = new Scanner(f);
            this.size = reader.nextInt();
            this.storage = TreeBasedTable.create();
            for (int y = 0; y < size; y++) {
                String line = reader.next();
                for (int x = 0; x < size; x++) {
                    char i = line.charAt(x);
                    if (i == 's' || i == 'S') {
                        storage.put(x, y, new SeaCell(x, y));
                    } else if (i == 'm' || i == 'M') {
                        storage.put(x, y, new MountainCell(x, y));
                    } else if (i == 't' || i == 'T') {
                        storage.put(x, y, new TundraCell(x, y));
                    } else if (i == 'c' || i == 'C') {
                        storage.put(x, y, new CaveCell(x, y));
                    } else if (i == 'p' || i == 'P') {
                        storage.put(x, y, new PowerplantCell(x, y));
                    } else if (i == 'g' || i == 'G') {
                        storage.put(x, y, new GrasslandCell(x, y));
                    } else {
                        throw new NoSuchElementException("cell '" + i + "' not found");
                    }
                }
            }
        } catch (IOException | IllegalStateException | NoSuchElementException ex) {
            throw ex;
        } finally {
            reader.close();
        }
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
        massPopulate(SeaCell.class, 6, 12, 0.5D);
        massPopulate(MountainCell.class, 6, 9, 0.5D);
        massPopulate(TundraCell.class, 6, 8, 0.5D);
        massPopulate(CaveCell.class, 6, 7, 0.5D);
        massPopulate(PowerplantCell.class, 6, 1, 0.8D);
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
            ignored.printStackTrace();
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
                        ignored.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.storage.toString();
    }

    public static List<WildEngimon> getSurroundingEngimon(int x, int y) {
        Map map = Map.getInstance();
        List<WildEngimon> wildEngimon = new ArrayList<WildEngimon>();
        for (int xi = x - 1; xi <= x + 1; xi++) {
            for (int yi = y - 1; yi <= y + 1; yi++) {
                try {
                    Cell cell = map.getCell(xi, yi);
                    if (cell.isOccupied() && cell.getOccupier() instanceof WildEngimon) {
                        wildEngimon.add((WildEngimon) cell.getOccupier());
                    }
                } catch (Exception e) {
                }
            }
        }
        return wildEngimon;
    }

}
