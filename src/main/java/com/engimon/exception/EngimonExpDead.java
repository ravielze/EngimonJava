package com.engimon.exception;

import com.engimon.entity.Engimon;

public class EngimonExpDead extends Exception {

    private static final long serialVersionUID = -8717529000514891247L;

    public EngimonExpDead(Engimon eng) {
        super("Engimon " + eng.getName() + " dead. Cause of dead: Max Cumulative Exp.");
    }

}
