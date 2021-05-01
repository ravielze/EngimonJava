package com.engimon.entity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import com.engimon.entity.engimon.Species;
import com.engimon.entity.skill.Skill;
import com.google.common.collect.Table;

public class StaticSerializer implements Serializable {

    private static final long serialVersionUID = 122133851481750778L;
    private Map<Integer, Skill> skillList = new TreeMap<Integer, Skill>();
    private Map<Integer, Species> speciesList = new TreeMap<Integer, Species>();
    private com.engimon.map.Map gameMap;
    private Spawner spawner;
    private Table<Integer, Integer, Serializable> mapOccupier;

    public StaticSerializer() {
    }

    private void take() {
        skillList.putAll(Skill.getSkillList());
        speciesList.putAll(Species.getSpeciesList());
        this.spawner = Spawner.getInstance();
        this.gameMap = com.engimon.map.Map.getInstance();
        this.mapOccupier = com.engimon.map.Map.wrap(this.gameMap);
    }

    private void dump() {
        Skill.setSkillList(skillList);
        Species.setSpeciesList(speciesList);
        Spawner.setInstance(this.spawner);
        com.engimon.map.Map.setInstance(this.gameMap);
        com.engimon.map.Map.unwrap(this.gameMap, mapOccupier);
    }

    public static StaticSerializer save() {
        StaticSerializer result = new StaticSerializer();
        result.take();
        return result;
    }

    public static void load(StaticSerializer ss) {
        ss.dump();
    }

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

}
