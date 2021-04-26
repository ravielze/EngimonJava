package com.engimon.entity;

import java.util.ArrayList;
import java.util.List;

import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.Species;

public final class GameConfig {

    public GameConfig() {

    }

    // TODO
    public static final List<Engimon> getStarterEngimon() {
        List<Engimon> starters = new ArrayList<Engimon>();
        starters.add(new Engimon(Species.getSpecies(1)));
        starters.add(new Engimon(Species.getSpecies(13)));
        starters.add(new Engimon(Species.getSpecies(25)));
        starters.add(new Engimon(Species.getSpecies(31)));
        starters.add(new Engimon(Species.getSpecies(37)));
        return starters;
    }

    public static int MAX_WILD_ENGIMON = 20;

}
