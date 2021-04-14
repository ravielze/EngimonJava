package com.engimon.entity;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.engimon.exception.SkillNotFound;

import org.jetbrains.annotations.NotNull;

public class Species extends Elementum {

    private String name;
    private List<String> message;
    private int speciesId;
    private static Map<Integer, Species> speciesList = new TreeMap<Integer, Species>();
    private Skill uniqueSkill;

    public Species(@NotNull Element firstElement, int speciesId, int uniqueSkillId, @NotNull String name,
            @NotNull String[] message) throws SkillNotFound {
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

    public Species(@NotNull Element firstElement, @NotNull Element secondElement, int speciesId, int uniqueSkillId,
            @NotNull String name, @NotNull String[] message) throws SkillNotFound {
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

    @NotNull
    public Skill getUniqueSkill() {
        return this.uniqueSkill;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
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
        if (o == null)
            return false;
        if (!(o instanceof Species)) {
            return false;
        }
        Species species = (Species) o;
        return speciesId == species.speciesId;
    }

    @NotNull
    public String getElementString() {
        return super.toString();
    }

}
