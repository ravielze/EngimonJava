package com.engimon.map;

import java.security.SecureRandom;

import com.engimon.entity.Player;
import com.engimon.map.biome.Cell;
import com.engimon.map.biome.GrasslandCell;
import com.engimon.map.biome.MountainCell;
import com.engimon.map.biome.SeaCell;
import com.engimon.map.biome.TundraCell;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class Map {

    private Table<Integer, Integer, Cell> storage;
    private int size;

    // TODO populate tree and rock
    public Map(int size, Player player) {
        this.size = size;
        this.storage = TreeBasedTable.create();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                storage.put(x, y, new GrasslandCell());
            }
        }
        massPopulate(MountainCell.class, 4, 3, 0.45D);
        massPopulate(SeaCell.class, 5, 4, 0.3D);
        massPopulate(TundraCell.class, 4, 3, 0.4D);
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
            storage.put(x, y, clazz.getConstructor().newInstance());
        } catch (Exception ignored) {
        }
        for (int rx = -1; rx <= 1; rx++) {
            for (int ry = -1; ry <= 1; ry++) {
                if (!isInRange(x + rx, y + ry))
                    continue;
                if (sr.nextDouble() < chance) {
                    try {
                        storage.put(x + rx, y + ry, clazz.getConstructor().newInstance());
                    } catch (Exception ignored) {
                    }
                }
            }
        }
    }

}
