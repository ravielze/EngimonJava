package com.engimon.entity;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.engimon.exception.SkillNotFound;

public class Species extends Elementum {

    private String name;
    private List<String> message;
    private int speciesId;
    private static Map<Integer, Species> speciesList = new TreeMap<Integer, Species>();
    private Skill uniqueSkill;

    public Species(Element firstElement, int speciesId, int uniqueSkillId, String name, String[] message)
            throws SkillNotFound {
        super(firstElement);
        this.speciesId = speciesId;
        this.name = name;
        this.uniqueSkill = Skill.getSkill(uniqueSkillId);
        if (this.uniqueSkill == null) {
            throw new SkillNotFound(uniqueSkillId);
        }
        this.message = new ArrayList<String>();
        if (message.length > 0) {
            for (String each : message) {
                if (each == null)
                    continue;
                if (each.length() == 0)
                    continue;
                this.message.add(each);
            }
        }
        speciesList.put(speciesId, this);
    }

    public Species(Element firstElement, Element secondElement, int speciesId, int uniqueSkillId, String name,
            String[] message) throws SkillNotFound {
        super(firstElement, secondElement);
        this.speciesId = speciesId;
        this.name = name;
        this.uniqueSkill = Skill.getSkill(uniqueSkillId);
        if (this.uniqueSkill == null) {
            throw new SkillNotFound(uniqueSkillId);
        }
        this.message = new ArrayList<String>();
        if (message.length > 0) {
            for (String each : message) {
                if (each == null)
                    continue;
                if (each.length() == 0)
                    continue;
                this.message.add(each);
            }
        }
        speciesList.put(speciesId, this);
    }

    public Skill getUniqueSkill() {
        return this.uniqueSkill;
    }

    public String getName() {
        return this.name;
    }

    public String interact() {
        SecureRandom rnd = new SecureRandom();
        return message.get(rnd.nextInt(message.size()));
    }

    public int getSpeciesId() {
        return this.speciesId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Species)) {
            return false;
        }
        Species species = (Species) o;
        return speciesId == species.speciesId;
    }

    public String getElementString() {
        return super.toString();
    }

}
