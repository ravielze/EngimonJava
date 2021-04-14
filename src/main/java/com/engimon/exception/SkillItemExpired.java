package com.engimon.exception;

import com.engimon.entity.skill.SkillItem;

public class SkillItemExpired extends Exception {

    private static final long serialVersionUID = 4699246476479206029L;

    private SkillItem skillItem;

    public SkillItemExpired(SkillItem si) {
        this.skillItem = si;
    }

    public SkillItem getSkillItem() {
        return this.skillItem;
    }

}
