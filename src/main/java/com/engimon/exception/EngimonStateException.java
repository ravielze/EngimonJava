package com.engimon.exception;

import com.engimon.entity.Engimon;

public class EngimonStateException extends Exception {

    private static final long serialVersionUID = 9081956252871156380L;

    private Engimon engimon;

    private StateError stateError;

    public EngimonStateException(Engimon eng, StateError se) {
        this.engimon = eng;
        this.stateError = se;
    }

    public Engimon getEngimon() {
        return this.engimon;
    }

    public StateError getStateError() {
        return this.stateError;
    }

    public enum StateError {
        MAX_SKILL_REACHED, SKILL_ALREADY_LEARNED, INCOMPATIBLE_ELEMENT, SKILL_INDEX_NOT_FOUND;
    }

}
