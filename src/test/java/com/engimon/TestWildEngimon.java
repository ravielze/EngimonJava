package com.engimon;

import com.engimon.entity.engimon.Species;
import com.engimon.entity.engimon.WildEngimon;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.SkillNotFound;
import com.engimon.map.biome.cells.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestWildEngimon {
    
    // Inisialisasi
    private Skill skill0 = new Skill(Element.ELECTRIC, 0, "Tidak Berguna", 0.0D);
    private Species species1;
    {
        try {
            species1 = new Species(Element.ELECTRIC, 101, 0, "Pikaco", new String[] { "sheeshhhh", "pikapika" });
        } catch (SkillNotFound ignored) {
        }
    }

    @Test
    @DisplayName("Test constructor WildEngimon")
    void testconstructor(){
        try {
            WildEngimon wildEngimon = new WildEngimon(species1, 10, new Cell(2, 2));
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
        assertEquals(false, wildEngimon == null);
    }
    // @Test
    // @DisplayName("Test constructor WildEngimon")
}
