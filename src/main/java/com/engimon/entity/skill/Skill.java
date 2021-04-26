package com.engimon.entity.skill;

import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.engimon.entity.engimon.Elementum;
import com.engimon.entity.enums.Element;

import org.jetbrains.annotations.NotNull;

public class Skill extends Elementum implements Comparable<Skill> {

    private static final long serialVersionUID = 1244181908986208537L;
    private static Map<Integer, Skill> skillList = new TreeMap<Integer, Skill>();

    public static Map<Integer, Skill> getSkillList() {
        return skillList;
    }

    public static void setSkillList(Map<Integer, Skill> x) {
        skillList.clear();
        skillList.putAll(x);
    }

    private int skillId;
    private String skillName;
    private double basePower;
    private int masteryLevel = 1;

    public Skill(@NotNull Element firstElement, int skillId, @NotNull String skillName, double basePower) {
        super(firstElement);
        this.skillId = skillId;
        this.skillName = skillName;
        this.basePower = basePower;
        skillList.put(skillId, this);
    }

    public Skill(@NotNull Element firstElement, @NotNull Element secondElement, int skillId, @NotNull String skillName,
            double basePower) {
        super(firstElement, secondElement);
        this.skillId = skillId;
        this.skillName = skillName;
        this.basePower = basePower;
        skillList.put(skillId, this);
    }

    public Skill(@NotNull Skill source, int masteryLevel) {
        super(source.getFirstElement(), source.getSecondElement());
        this.skillId = source.skillId;
        this.skillName = source.skillName;
        this.basePower = source.basePower;
        this.masteryLevel = masteryLevel;
    }

    public Skill() {
        super();
        // Constructor for Serializable Access
    }

    @Nullable
    public static Skill getSkill(int id) {
        return skillList.getOrDefault(id, null);
    }

    public int getSkillId() {
        return this.skillId;
    }

    public String getSkillName() {
        return this.skillName;
    }

    public double getBasePower() {
        return this.basePower;
    }

    public double getPower() {
        return this.basePower * this.masteryLevel;
    }

    public int getMasteryLevel() {
        return this.masteryLevel;
    }

    public void addMasteryLevel() {
        this.masteryLevel++;
        this.masteryLevel = Math.min(this.masteryLevel, 3);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Skill)) {
            return false;
        }
        Skill skill = (Skill) o;
        return skillId == skill.skillId;
    }

    @Override
    @NotNull
    public String toString() {
        return String.format("%s/%s/Power %.2f", this.skillName, super.toString(), this.basePower);
    }

    private void readObject(ObjectInputStream aInputStream) throws IOException, ClassNotFoundException {
        aInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream aOutputStream) throws IOException, ClassNotFoundException {
        aOutputStream.defaultWriteObject();
    }

    @Override
    public int compareTo(Skill o) {
        return Comparator.comparing(Skill::getMasteryLevel).compare(this, o);
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(this.skillId).hashCode();
    }

    public Image getIcon() {
        // TODO image
        return null;
    }

}
