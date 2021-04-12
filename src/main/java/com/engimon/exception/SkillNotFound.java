package com.engimon.exception;

public class SkillNotFound extends Exception {

    private static final long serialVersionUID = -8100509982311966386L;

    public SkillNotFound(int id) {
        super("Skill with id " + id + " is not found.");
    }

}
