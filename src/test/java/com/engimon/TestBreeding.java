package com.engimon;

import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.Species;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.SkillNotFound;
import com.engimon.menu.breeding.Breeding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBreeding {

    @SuppressWarnings("unused")
    private Skill skill1 = new Skill(Element.ELECTRIC, 1, "SambarListrik", 100.0D);
    private Skill skill2 = new Skill(Element.ELECTRIC, 2, "KilatListrik", 50.0D);
    private Species species1;
    private Species species2;
    {
        try {
            species1 = new Species(Element.ELECTRIC, 101, 1, "Pikaco", new String[] { "sheeshhhh", "pikapika" });
            species2 = new Species(Element.ELECTRIC, 102, 2, "Electabuz", new String[] { "buzz", "buzbuzbuzz" });
        } catch (SkillNotFound ignored) {
        }
    }
    private Engimon engimon1 = new Engimon(species1);
    private Engimon engimon2 = new Engimon(species2);


    @Test
    @DisplayName("Test Breeding")
    void testBreeding() {
        Breeding b = new Breeding(engimon1, engimon2);
        
    }
}