package com.engimon.entity.engimon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import com.engimon.entity.ElementTable;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.EngimonDeadException;
import com.engimon.exception.EngimonDeadException.DeadCause;
import com.engimon.exception.EngimonStateException;
import com.engimon.exception.EngimonStateException.StateError;
import com.engimon.inventory.Storable;
import com.engimon.map.biome.LivingEntity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Engimon implements LivingEntity, Storable, Comparable<Engimon>, Serializable {

    private static final long serialVersionUID = 5993563572031342255L;
    private String customName;
    private Species species;
    private Engimon parentFirst, parentSecond;
    private List<Skill> skills;
    private int experience = 0, cumulativeExperience = 0, level = 1;
    protected int life = 3;

    public static final int MAX_CUMULATIVE_EXP = 20000;

    public Engimon() {
        // Constructor for Serializable Access
    }

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

    public Engimon(@NotNull Species species) {
        this.species = species;
        this.customName = null;
        this.skills = new ArrayList<>(4);
        try {
            addSkill(species.getUniqueSkill());
        } catch (EngimonStateException ignored) {
            // ignored karena gak mungkin
        }
    }

    public Engimon(@NotNull WildEngimon wildEngimon) {
        this.species = wildEngimon.getSpecies();
        this.customName = null;
        this.skills = new ArrayList<>(4);
        try {
            addSkill(species.getUniqueSkill());
        } catch (EngimonStateException ignored) {
            // ignored karena gak mungkin
        }
    }

    public Engimon(@NotNull Species species, @NotNull Engimon parentFirst, @NotNull Engimon parentSecond, String name) {
        this.customName = name;
        this.species = species;
        this.parentFirst = parentFirst;
        this.parentSecond = parentSecond;
        this.skills = new ArrayList<>(4);
        try {
            addSkill(species.getUniqueSkill());
        } catch (EngimonStateException ignored) {
            // ignored karena gak mungkin
        }
    }

    @Nullable
    public Skill getSkill(int id) {
        return this.skills.get(id);
    }

    @NotNull
    public Engimon addSkill(@NotNull Skill s) throws EngimonStateException {
        if (this.skills.size() > 4) {
            throw new EngimonStateException(this, StateError.MAX_SKILL_REACHED);
        }
        if (this.skills.contains(s)) {
            throw new EngimonStateException(this, StateError.SKILL_ALREADY_LEARNED);
        }
        if (!(this.getSpecies().isOneOf(s.getFirstElement()) && this.getSpecies().isOneOf(s.getSecondElement()))) {
            throw new EngimonStateException(this, StateError.INCOMPATIBLE_ELEMENT);
        }
        this.skills.add(s);
        return this;
    }

    @NotNull
    public Engimon replaceSkill(int id, @NotNull Skill s) throws EngimonStateException {
        if (id < 0 || id >= 4) {
            throw new EngimonStateException(this, StateError.SKILL_INDEX_NOT_FOUND);
        }
        if (this.skills.contains(s)) {
            throw new EngimonStateException(this, StateError.SKILL_ALREADY_LEARNED);
        }
        if (!(this.getSpecies().isOneOf(s.getFirstElement()) && this.getSpecies().isOneOf(s.getSecondElement()))) {
            throw new EngimonStateException(this, StateError.MAX_SKILL_REACHED);
        }
        this.skills.set(id, s);
        return this;
    }

    public boolean hasParent() {
        return this.parentFirst != null & this.parentSecond != null;
    }

    @Nullable
    public String getName() {
        return this.customName != null ? this.customName : this.species.getName();
    }

    public void setName(@Nullable String customName) {
        this.customName = customName;
    }

    @NotNull
    public Species getSpecies() {
        return this.species;
    }

    @Nullable
    public Engimon getParentFirst() {
        return this.parentFirst;
    }

    @Nullable
    public Engimon getParentSecond() {
        return this.parentSecond;
    }

    public int getExperience() {
        return this.experience;
    }

    public void addExperience(int exp) throws EngimonDeadException {
        this.cumulativeExperience += exp;
        this.experience += exp;
        int neededExperience = level * 100;
        while (this.experience >= neededExperience) {
            this.level++;
            this.experience -= neededExperience;
            neededExperience = level * 100;
        }
        if (this.cumulativeExperience >= MAX_CUMULATIVE_EXP) {
            throw new EngimonDeadException(this, DeadCause.EXP_LIMIT);
        }
    }

    @NotNull
    protected String interact() {
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

    public void reduceLife() throws EngimonDeadException {
        this.life--;
        if (this.life == 0) {
            throw new EngimonDeadException(this, DeadCause.LIFE);
        }
    }

    @Override
    public int compareTo(Engimon o) {
        int compareSpecies = Comparator.comparing(Species::getElements).thenComparing(Species::getFirstElement)
                .thenComparing(Species::getSecondElement).compare(this.getSpecies(), o.getSpecies());
        if (compareSpecies == 0) {
            int compareEngi = Comparator.comparing(Engimon::getLevel).compare(this, o);
            if (compareEngi == 0) {
                return Math.max(Math.min(this.getName().compareTo(o.getName()), 1), -1);
            }
            return compareEngi;
        }
        return compareSpecies;
    }

    @Override
    @NotNull
    public String toString() {
        return String.format("%s/%s/Lv.%d", getName(), this.species.getElementString(), getLevel());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
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

    public double getPower(Engimon other) {
        Species x = this.species;
        Species y = other.species;
        double a = Math.max(ElementTable.getMultiplier(x.getFirstElement(), y.getFirstElement()),
                ElementTable.getMultiplier(x.getFirstElement(), y.getSecondElement()));
        double b = Math.max(ElementTable.getMultiplier(x.getSecondElement(), y.getFirstElement()),
                ElementTable.getMultiplier(x.getSecondElement(), y.getSecondElement()));
        double sum = this.skills.stream().filter(Objects::nonNull).map(Skill::getPower).reduce(0D, Double::sum);
        return level * Math.max(a, b) + sum;
    }

}
