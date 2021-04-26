package com.engimon.entity;

import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.Species;

public class Cheat {

    public Cheat() {

    }
    private static Engimon firstEngimon;
    private static Engimon secondEngimon;
    private static Engimon thirdEngimon;
    
    public static Engimon getEngimon() {
        if (firstEngimon != null) {
            return firstEngimon;
        }
        Species species1 = Species.getSpecies(1);
        firstEngimon = new Engimon(species1);
        return firstEngimon;
    }

    public static Engimon getSecondEngimon() { // Fungsi ngetes doang
        if (secondEngimon != null) {
            return secondEngimon;
        }
        Species species1 = Species.getSpecies(2);
        secondEngimon = new Engimon(species1);
        return secondEngimon;
    }

    public static Engimon getThirdEngimon() { // Fungsi ngetes doang
        if (thirdEngimon != null) {
            return thirdEngimon;
        }
        Species species1 = Species.getSpecies(3);
        thirdEngimon = new Engimon(species1);
        return thirdEngimon;
    }
}
