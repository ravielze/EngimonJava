package com.engimon.entity;

import com.engimon.inventory.Storable;

public class SkillItem implements Storable {

    private Skill skill;
    private int amount = 0;

    public SkillItem(Skill skill) {
        this.skill = skill;
    }

    public int getAmount() {
        return this.amount;
    }

    public Engimon learn(Engimon eng) {
        try {
            Engimon result = eng.addSkill(this.skill);
            this.amount--;
            return result;
        } catch (IllegalStateException ex) {
            // TODO out the exception
        }
        return eng;
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

}
