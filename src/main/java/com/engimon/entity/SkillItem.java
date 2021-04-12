package com.engimon.entity;

import com.engimon.exception.EngimonState;
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

    public Engimon learn(Engimon eng) throws EngimonState {
        try {
            Engimon result = eng.addSkill(this.skill);
            this.amount--;
            return result;
        } catch (EngimonState ex) {
            throw ex;
        }
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
