package com.engimon.exception;

import com.engimon.entity.engimon.Engimon;

public class EngimonDeadException extends Exception {

    private static final long serialVersionUID = -8717529000514891247L;

    private Engimon engimon;
    private DeadCause deadCause;

    public EngimonDeadException(Engimon eng, DeadCause dc) {
        this.engimon = eng;
        this.deadCause = dc;
    }

    public Engimon getEngimon() {
        return this.engimon;
    }

    public DeadCause getDeadCause() {
        return this.deadCause;
    }

    public enum DeadCause {
        EXP_LIMIT, LIFE;
    }

}
