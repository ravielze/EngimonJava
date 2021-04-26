package com.engimon.entity.skill;

import java.awt.Image;
import java.util.Comparator;

import com.engimon.entity.engimon.Engimon;
import com.engimon.exception.EngimonStateException;
import com.engimon.exception.SkillItemExpired;
import com.engimon.inventory.Storable;

import org.jetbrains.annotations.NotNull;

public class SkillItem implements Storable, Comparable<SkillItem> {

    private Skill skill;
    private int amount = 0;

    public SkillItem(Skill skill) {
        this.skill = skill;
    }

    public int getAmount() {
        return this.amount;
    }

    @NotNull
    public String getName() {
        return this.skill.getSkillName();
    }

    @NotNull
    public Engimon learn(@NotNull Engimon eng) throws EngimonStateException, SkillItemExpired {
        Engimon result = eng.addSkill(new Skill(this.skill, 1));
        this.amount--;
        if (this.amount == 0) {
            throw new SkillItemExpired(this);
        }
        return result;
    }

    @NotNull
    public Engimon learn(@NotNull Engimon eng, int index) throws EngimonStateException, SkillItemExpired {
        Engimon result = eng.replaceSkill(index, new Skill(this.skill, 1));
        this.amount--;
        if (this.amount == 0) {
            throw new SkillItemExpired(this);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof SkillItem)) {
            return false;
        }
        SkillItem skillItem = (SkillItem) o;
        return this.skill.equals(skillItem.skill);
    }

    @Override
    @NotNull
    public String toString() {
        return String.format("%s x%d", this.skill.toString(), this.amount);
    }

    @Override
    public int compareTo(@NotNull SkillItem o) {
        return Comparator.comparing(Skill::getBasePower).thenComparing(Skill::getSkillName).compare(this.skill,
                o.skill);
    }

    public Image getElementIcon() {
        return this.skill.getElementIcon();
    }

}
