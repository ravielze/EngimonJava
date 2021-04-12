package com.engimon.exception;

import com.engimon.entity.Engimon;

public class EngimonLifeDead extends Exception {

    private static final long serialVersionUID = -3100906700479124035L;

    public EngimonLifeDead(Engimon eng) {
        super("Engimon " + eng.getName() + " dead. Cause of dead: Life.");
    }

}
