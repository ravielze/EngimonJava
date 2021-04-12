package com.engimon.entity;

import java.util.Map;
import java.util.TreeMap;

public class Skill extends Elementum {

    private static Map<Integer, Skill> skillList = new TreeMap<Integer, Skill>();
    private int skillId;
    private String skillName;
    private double basePower;
    private int masteryLevel = 0;

    public Skill(Element firstElement, int skillId, String skillName, double basePower) {
        super(firstElement);
        this.skillId = skillId;
        this.skillName = skillName;
        this.basePower = basePower;
        skillList.put(skillId, this);
    }

    public Skill(Element firstElement, Element secondElement, int skillId, String skillName, double basePower) {
        super(firstElement, secondElement);
        this.skillId = skillId;
        this.skillName = skillName;
        this.basePower = basePower;
        skillList.put(skillId, this);
    }

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
        if (!(o instanceof Skill)) {
            return false;
        }
        Skill skill = (Skill) o;
        return skillId == skill.skillId;
    }

}
