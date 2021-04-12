package com.engimon.entity;

public class Engimon {

    private String customName;
    private Species species;
    private Engimon parentFirst, parentSecond;
    // TODO skill
    private int experience = 0, cumulativeExperience = 0, level = 1, life = 3;

    public Engimon(Species species) {
        this.species = species;
        this.customName = null;
    }

    public Engimon(Species species, Engimon parentFirst, Engimon parentSecond, String name) {
        this.customName = name;
        this.species = species;
        this.parentFirst = parentFirst;
        this.parentSecond = parentSecond;
    }

    public boolean hasParent() {
        return this.parentFirst != null & this.parentSecond != null;
    }

    public String getName() {
        return this.customName != null ? this.customName : this.species.getName();
    }

    public void setName(String customName) {
        this.customName = customName;
    }

    public Species getSpecies() {
        return this.species;
    }

    public Engimon getParentFirst() {
        return this.parentFirst;
    }

    public Engimon getParentSecond() {
        return this.parentSecond;
    }

    public int getExperience() {
        return this.experience;
    }

    public void addExperience(int exp) {
        this.cumulativeExperience += exp;
        this.experience += exp;
        int neededExperience = level * 100;
        while (this.experience >= neededExperience) {
            this.level++;
            this.experience -= neededExperience;
            neededExperience = level * 100;
        }
    }

    public int getCumulativeExperience() {
        return this.cumulativeExperience;
    }

    public int getLevel() {
        return this.level;
    }

    public int getLife() {
        return this.life;
    }

    public void reduceLife() {
        this.life--;
    }

}
