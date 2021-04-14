package com.engimon.entity;

import org.jetbrains.annotations.NotNull;

public class WildEngimon extends Engimon {

    public WildEngimon(@NotNull Species species) {
        super(species);
        this.life = 1;
    }

}
