package com.engimon.entity;

import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

public class Skill extends Elementum {

    private static Map<Integer, Skill> skillList = new TreeMap<Integer, Skill>();
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

    public int getMasteryLevel() {
        return this.masteryLevel;
    }

    public void addMasteryLevel() {
        this.masteryLevel++;
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

}
