package com.engimon.entity;

import java.security.SecureRandom;

import com.engimon.entity.engimon.Species;
import com.engimon.entity.engimon.WildEngimon;
import com.engimon.exception.CellException;
import com.engimon.exception.EngimonStateException;
import com.engimon.map.Map;

public class Spawner {

    // TODO
    private static Spawner instance;

    synchronized public static Spawner getInstance() {
        return instance;
    }

    private Map map;
    private int wildEngimonSpawned = 0;

    public Spawner() {
    }

    public void spawn() {
        map = Map.getInstance();
        SecureRandom sr = new SecureRandom();
        int chance = GameConfig.SPAWN_CHANCE;
        for (int y = 0; y < map.getSize(); y++) {
            for (int x = 0; x < map.getSize(); x++) {
                if (wildEngimonSpawned < GameConfig.MAX_WILD_ENGIMON && chance < sr.nextInt(100)) {
                    try {
                        new WildEngimon(Species.getRandomSpecies(), 2, map.getCell(x, y));
                        wildEngimonSpawned++;
                    } catch (EngimonStateException er) {

                    } catch (CellException er) {

                    }
                }
            }
        }
    }

    public void reducePopulation() {
        wildEngimonSpawned -= 1;
    }

}
