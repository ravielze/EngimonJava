package com.engimon.entity;

import java.util.ArrayList;
import java.util.List;

import com.engimon.entity.engimon.Engimon;

public final class GameConfig {

    public GameConfig() {

    }

    // TODO
    public static final List<Engimon> getStarterEngimon() {
        List<Engimon> starters = new ArrayList<Engimon>();
        return starters;
    }

    public static int MAX_WILD_ENGIMON = 20;

}
