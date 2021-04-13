package com.engimon.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.engimon.exception.EngimonExpDead;
import com.engimon.exception.EngimonLifeDead;
import com.engimon.exception.EngimonState;
import com.engimon.inventory.Storable;

public class Engimon implements Storable, Comparable<Engimon> {

    private String customName;
    private Species species;
    private Engimon parentFirst, parentSecond;
    private List<Skill> skills;
    private int experience = 0, cumulativeExperience = 0, level = 1;
    protected int life = 3;

    public static final int MAX_CUMULATIVE_EXP = 20000;

    public Engimon(Species species) {
        this.species = species;
        this.customName = null;
        this.skills = new ArrayList<>(4);
        try {
            addSkill(species.getUniqueSkill());
        } catch (EngimonState ignored) {
            // ignored karena gak mungkin
        }
    }

    public Engimon(WildEngimon wildEngimon) {
        this.species = wildEngimon.getSpecies();
        this.customName = null;
        this.skills = new ArrayList<>(4);
        try {
            addSkill(species.getUniqueSkill());
        } catch (EngimonState ignored) {
            // ignored karena gak mungkin
        }
    }

    public Engimon(Species species, Engimon parentFirst, Engimon parentSecond, String name) {
        this.customName = name;
        this.species = species;
        this.parentFirst = parentFirst;
        this.parentSecond = parentSecond;
        this.skills = new ArrayList<>(4);
        try {
            addSkill(species.getUniqueSkill());
        } catch (EngimonState ignored) {
            // ignored karena gak mungkin
        }
    }

    public Skill getSkill(int id) {
        return this.skills.get(id);
    }

    protected Engimon addSkill(Skill s) throws EngimonState {
        if (this.skills.size() > 4) {
            throw new EngimonState(this, "already has 4 skills.");
        }
        if (this.skills.contains(s)) {
            throw new EngimonState(this, "already learned that skill.");
        }
        if (!(this.getSpecies().isOneOf(s.getFirstElement()) && this.getSpecies().isOneOf(s.getSecondElement()))) {
            throw new EngimonState(this, "has incompatible element(s) with the skill.");
        }
        this.skills.add(s);
        return this;
    }

    protected Engimon replaceSkill(int id, Skill s) throws EngimonState {
        if (id < 0 || id >= 4) {
            throw new EngimonState(this, "does not have skill with slot index " + id);
        }
        if (this.skills.contains(s)) {
            throw new EngimonState(this, "already learned that skill.");
        }
        if (!(this.getSpecies().isOneOf(s.getFirstElement()) && this.getSpecies().isOneOf(s.getSecondElement()))) {
            throw new EngimonState(this, "has incompatible element(s) with the skill.");
        }
        this.skills.set(id, s);
        return this;
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

    public void addExperience(int exp) throws EngimonExpDead {
        this.cumulativeExperience += exp;
        this.experience += exp;
        int neededExperience = level * 100;
        while (this.experience >= neededExperience) {
            this.level++;
            this.experience -= neededExperience;
            neededExperience = level * 100;
        }
        if (this.cumulativeExperience >= MAX_CUMULATIVE_EXP) {
            throw new EngimonExpDead(this);
        }
    }

    public String interact() {
        return this.species.interact();
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

    public void reduceLife() throws EngimonLifeDead {
        this.life--;
        if (this.life == 0) {
            throw new EngimonLifeDead(this);
        }
    }

    @Override
    public int compareTo(Engimon o) {
        int compareSpecies = Comparator.comparing(Species::getElements).thenComparing(Species::getFirstElement)
                .thenComparing(Species::getSecondElement).compare(this.getSpecies(), o.getSpecies());
        if (compareSpecies == 0) {
            return Comparator.comparing(Engimon::getLevel).thenComparing(Engimon::getName).compare(this, o);
        }
        return compareSpecies;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/Lv.%d", getName(), this.species.getElementString(), getLevel());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Engimon)) {
            return false;
        }
        Engimon engimon = (Engimon) o;
        boolean parentSame = (engimon.hasParent() && this.hasParent());

        // satu gak punya parent & satu punya parent
        if (!parentSame)
            return false;

        // sampe disini berarti either duaduanya punya parent or not

        // kalau punya parent baru cek sama atau enggak
        if (this.hasParent() && engimon.hasParent()) {
            parentSame = (engimon.parentFirst.equals(this.parentFirst)
                    && this.parentSecond.equals(engimon.parentSecond));
        }
        return getName().equals(engimon.getName()) && this.species.equals(engimon.species)
                && skills.equals(engimon.skills) && this.experience == engimon.experience
                && this.cumulativeExperience == engimon.cumulativeExperience && this.level == engimon.level
                && this.life == engimon.life && parentSame;
    }

}
