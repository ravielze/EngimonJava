package com.engimon.entity;

import com.engimon.inventory.Storable;

public class SkillItem implements Storable {

    private Skill skill;

    public SkillItem(Skill skill) {
        this.skill = skill;
    }

    public Skill getSkill() {
        return this.skill;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SkillItem)) {
            return false;
        }
        SkillItem skillItem = (SkillItem) o;
        return this.getSkill().equals(skillItem.getSkill());
    }

}
