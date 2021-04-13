package com.engimon.entity;

import java.util.Comparator;

import com.engimon.exception.EngimonState;
import com.engimon.inventory.Storable;

public class SkillItem implements Storable, Comparable<SkillItem> {

    private Skill skill;
    private int amount = 0;

    public SkillItem(Skill skill) {
        this.skill = skill;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getName() {
        return this.skill.getSkillName();
    }

    public Engimon learn(Engimon eng) throws EngimonState {
        Engimon result = eng.addSkill(new Skill(this.skill, 1));
        this.amount--;
        return result;
    }

    public Engimon learn(Engimon eng, int index) throws EngimonState {
        Engimon result = eng.replaceSkill(index, new Skill(this.skill, 1));
        this.amount--;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SkillItem)) {
            return false;
        }
        SkillItem skillItem = (SkillItem) o;
        return this.skill.equals(skillItem.skill);
    }

    @Override
    public String toString() {
        return String.format("%s x%d", this.skill.toString(), this.amount);
    }

    @Override
    public int compareTo(SkillItem o) {
        return Comparator.comparing(Skill::getBasePower).thenComparing(Skill::getSkillName).compare(this.skill,
                o.skill);
    }

}
