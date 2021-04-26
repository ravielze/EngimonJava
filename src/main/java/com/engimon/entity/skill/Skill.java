package com.engimon.entity.skill;

import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.engimon.common.DataReader;
import com.engimon.common.ResourceReader;
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

    public static void load(DataReader dr) {
        List<String[]> data = dr.getResult();
        data.remove(0);
        for (String[] each : data) {
            if (each.length != 5)
                continue;
            int skillId = Integer.valueOf(each[0]);
            String skillName = each[1];
            Element firstElement = Element.valueOf(each[2]);
            Element secondElement = Element.valueOf(each[3]);
            double basePower = Double.valueOf(each[4]);
            if (secondElement != Element.NONE) {
                new Skill(firstElement, secondElement, skillId, skillName, basePower);
            } else {
                new Skill(firstElement, skillId, skillName, basePower);
            }
        }
    }

    @NotNull
    public static Skill getRandomSkill(Elementum el, List<Skill> ignoredSkill) {
        List<Skill> filtered = skillList.values().stream().filter(x -> x.elementEquals(el) && !ignoredSkill.contains(x))
                .collect(Collectors.toList());
        if (filtered.isEmpty())
            return null;
        SecureRandom sr = new SecureRandom();
        Collections.shuffle(filtered);
        int randomIndex = sr.nextInt(filtered.size());
        return filtered.get(randomIndex);
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

    public boolean elementEquals(Elementum el) {
        return super.equals(el);
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

    public Image getSkillIcon() {
        if (this.masteryLevel == 1) {
            return getElementIcon();
        }
        return ResourceReader.getImage("Icons/" + getFirstElement().toString() + "_" + this.masteryLevel + ".png", 50,
                50);
    }

}
