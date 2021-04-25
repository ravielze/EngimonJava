package com.engimon.entity;

import java.util.ArrayList;
import java.util.List;

import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.Species;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.SkillNotFound;

public final class GameConfig {


    public GameConfig() {
        
    }
    // TODO
    public static final List<Engimon> getStarterEngimon() {
        List<Engimon> starters = new ArrayList<Engimon>();
        return starters;
    }
    public static Engimon getEngimon() {
        try {
            Skill skill0 = new Skill(Element.ELECTRIC, 0, "Tidak Berguna", 0.0D);

            Species species1 = new Species(Element.ELECTRIC, 101, 0, "Pikaco", new String[] { "sheeshhhh", "pikapika" });
            Engimon engimon1 = new Engimon(species1);
            return engimon1;
        }catch (SkillNotFound ignored) {
            return null;
        }
    }

    public static int SPAWN_CHANCE = 50; // x%
    public static int MAX_WILD_ENGIMON = 30;
}
