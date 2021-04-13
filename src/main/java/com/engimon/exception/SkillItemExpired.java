package com.engimon.exception;

import com.engimon.entity.SkillItem;

public class SkillItemExpired extends Exception {

    private static final long serialVersionUID = 4699246476479206029L;

    public SkillItemExpired(SkillItem si) {
        super("Item " + si.getName() + " is ran out of amount.");
    }

}
