package com.engimon.entity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.SecureRandom;

import com.engimon.entity.engimon.Species;
import com.engimon.entity.engimon.WildEngimon;
import com.engimon.entity.skill.Skill;
import com.engimon.map.Map;

public class Spawner implements Serializable {
    private static final long serialVersionUID = 2993563572121342245L;

    private static Spawner instance;

    synchronized public static Spawner getInstance() {
        if (instance == null) {
            instance = new Spawner();
        }
        return instance;
    }

    private Map map;
    private int wildEngimonSpawned = 0;

    public Spawner() {
    }

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

    public void spawn() {
        if (wildEngimonSpawned >= GameConfig.MAX_WILD_ENGIMON)
            return;
        map = Map.getInstance();
        SecureRandom sr = new SecureRandom();
        int x = sr.nextInt(map.getSize());
        int y = sr.nextInt(map.getSize());
        int level = sr.nextInt(wildEngimonSpawned + 4) + 1;
        try {
            WildEngimon we = new WildEngimon(Species.getRandomSpecies(), level, map.getCell(x, y));
            int skills = (sr.nextInt(3) + sr.nextInt(3)) % 3;
            int skillCount = 0;
            if (skills == 1) {
                skillCount = 3;
            } else if (skills == 0) {
                skillCount = 2;
            } else if (skills == 3) {
                skillCount = 1;
            }
            while (skillCount > 0) {
                Skill sk = Skill.getRandomSkill(we.getSpecies(), we.getAllSkills());
                if (sk == null)
                    break;
                we.addSkill(sk);
                skillCount--;
            }
            wildEngimonSpawned++;
        } catch (Exception ignored) {

        }
    }

    public void reducePopulation() {
        wildEngimonSpawned -= 1;
    }

    public synchronized void print(String x) {
        System.out.println(x);
    }

}
