package com.engimon.exception;

import com.engimon.entity.Engimon;

public class EngimonState extends Exception {

    private static final long serialVersionUID = 9081956252871156380L;

    public EngimonState(Engimon eng, String thing) {
        super("Engimon " + eng.getName() + " " + thing);
    }

}
