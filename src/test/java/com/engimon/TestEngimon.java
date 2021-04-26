package com.engimon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.Species;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.EngimonDeadException;
import com.engimon.exception.EngimonStateException;
import com.engimon.exception.SkillNotFound;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestEngimon {

    @SuppressWarnings("unused")
    private Skill skill0 = new Skill(Element.ELECTRIC, 0, "Tidak Berguna", 0.0D);
    private Skill skill1 = new Skill(Element.ELECTRIC, 1, "SambarListrik", 50.0D);
    private Skill skill2 = new Skill(Element.ELECTRIC, 2, "KilatListrik", 50.0D);
    private Skill skill3 = new Skill(Element.ELECTRIC, 3, "Halilintar", 150.0D);
    private Skill skill4 = new Skill(Element.ELECTRIC, 4, "SentrumListrik", 80.0D);
    private Skill skill5 = new Skill(Element.FIRE, 5, "Ember", 50.0D);
    private Species species1;
    private Species species2;
    private Species species3;
    {
        try {
            species1 = new Species(Element.ELECTRIC, 101, 0, "Pikaco", new String[] { "sheeshhhh", "pikapika" });
            species2 = new Species(Element.ELECTRIC, 102, 2, "Electabuz", new String[] { "buzz", "buzbuzbuzz" });
            species3 = new Species(Element.GROUND, 103, 5, "Armadilo", new String[] { "wiii", "saya berguling!" });
        } catch (SkillNotFound ignored) {
        }
    }

    @Test
    @DisplayName("Test getSkill")
    void testgetSkill() {
        try {
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill1);
            engimon1.addSkill(skill2);
            assertEquals(engimon1.getSkill(1), Skill.getSkill(1));
            assertEquals(engimon1.getSkill(2), Skill.getSkill(2));
        } catch (EngimonStateException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test addSkill - Penuh")
    void testaddSkill1() {
        try {
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill1);
            engimon1.addSkill(skill2);
            engimon1.addSkill(skill3);
            engimon1.addSkill(skill4);
        } catch (EngimonStateException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test addSkill - yang sudah ada")
    void testaddSkill2() {
        try {
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill1);
            engimon1.addSkill(skill1);
        } catch (EngimonStateException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test addSkill - elemen beda")
    void testaddSkill3() {
        try {
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill5);
        } catch (EngimonStateException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test replaceSkill - idx not found")
    void testreplaceSkill1() {
        try {
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill3);
            engimon1.addSkill(skill1);
            engimon1.replaceSkill(2, skill2);
        } catch (EngimonStateException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test replaceSkill - skill already learned")
    void testreplaceSkill2() {
        try {
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill1);
            engimon1.addSkill(skill2);
            engimon1.replaceSkill(2, skill1);
        } catch (EngimonStateException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test addSkill - elemen beda")
    void testreplaceSkill3() {
        try {
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill1);
            engimon1.replaceSkill(1, skill5);
        } catch (EngimonStateException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test hasParent")
    void testhasParent() {
        Engimon engimon1 = new Engimon(species1);
        Engimon engimon2 = new Engimon(species2);
        Engimon engimon3 = new Engimon(species1, engimon1, engimon2);
        assertEquals(true, engimon3.hasParent());
        assertEquals(false, engimon1.hasParent());
    }

    @Test
    @DisplayName("Test getName")
    void testgetName() {
        Engimon engimon1 = new Engimon(species1);
        assertEquals("Pikaco", engimon1.getName());
    }

    @Test
    @DisplayName("Test setName")
    void testsetName() {
        Engimon engimon1 = new Engimon(species1);
        engimon1.setName("Pikacov2");
        assertEquals("Pikacov2", engimon1.getName());
    }

    @Test
    @DisplayName("Test getSpecies")
    void testgetSpecies() {
        Engimon engimon1 = new Engimon(species1);
        assertEquals(species1, engimon1.getSpecies());
    }

    @Test
    @DisplayName("Test getParentFirst")
    void testgetParentFirst() {
        Engimon engimon1 = new Engimon(species1);
        Engimon engimon2 = new Engimon(species2);
        Engimon engimon3 = new Engimon(species1, engimon1, engimon2);
        assertEquals(engimon1, engimon3.getParentFirst());
    }

    @Test
    @DisplayName("Test getParentSecond")
    void testgetParentSecond() {

        Engimon engimon1 = new Engimon(species1);
        Engimon engimon2 = new Engimon(species2);
        Engimon engimon3 = new Engimon(species1, engimon1, engimon2);
        assertEquals(engimon2, engimon3.getParentSecond());

    }

    @Test
    @DisplayName("Test getExperience")
    void testgetExperience() {
        try {
            Engimon engimon1 = new Engimon(species1);
            assertEquals(0, engimon1.getExperience());
            engimon1.addExperience(50);
            assertEquals(50, engimon1.getExperience());
            engimon1.addExperience(150);
            assertEquals(100, engimon1.getExperience());
        } catch (EngimonDeadException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test addExperience - pass max_cumulative_exp")
    void testaddExperience() {
        try {
            Engimon engimon1 = new Engimon(species1);
            engimon1.addExperience(20100);
        } catch (EngimonDeadException e) {
            e.getMessage();
        }
    }

    // Fungsi interact di test di Species

    @Test
    @DisplayName("Test getCumulativeExperience")
    void testgetCumulativeExperience() {
        try {
            Engimon engimon1 = new Engimon(species1);
            assertEquals(0, engimon1.getCumulativeExperience());
            engimon1.addExperience(250);
            assertEquals(250, engimon1.getCumulativeExperience());
        } catch (EngimonDeadException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test getLevel")
    void testgetLevel() {
        try {
            Engimon engimon1 = new Engimon(species1);
            engimon1.addExperience(350);
            assertEquals(3, engimon1.getLevel());
        } catch (EngimonDeadException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test getLife")
    void testgetLife() {
        Engimon engimon1 = new Engimon(species1);
        engimon1.getLife();
        assertEquals(3, engimon1.getLife());
    }

    @Test
    @DisplayName("Test reduceLife : error reduce")
    void testreduceLife1() {
        try {
            Engimon engimon1 = new Engimon(species1);
            assertEquals(3, engimon1.getLife());
            engimon1.reduceLife();
            assertEquals(2, engimon1.getLife());
            engimon1.reduceLife();
            assertEquals(1, engimon1.getLife());
        } catch (EngimonDeadException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test reduceLife : hp 0")
    void testreduceLife2() {
        try {
            Engimon engimon1 = new Engimon(species1);
            engimon1.reduceLife();
            engimon1.reduceLife();
            engimon1.reduceLife();
        } catch (EngimonDeadException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test compareTo ")
    void testcompareTo() {
        Engimon engimon1 = new Engimon(species1);
        Engimon engimon2 = new Engimon(species2);
        Engimon engimon11 = new Engimon(species1);
        assertEquals(1, engimon1.compareTo(engimon2));
        assertEquals(0, engimon1.compareTo(engimon11));
        assertEquals(-1, engimon2.compareTo(engimon1));
    }

    @Test
    @DisplayName("Test toString ")
    void testtoString() {
        Engimon engimon1 = new Engimon(species1);
        assertEquals("Pikaco/ELECTRIC/Lv.1", engimon1.toString());
    }

    @Test
    @DisplayName("Test breeding")
    void testBreeding() {
        Engimon engimon1 = new Engimon(species1);
        Engimon engimon2 = new Engimon(species2);
        Engimon s1;
        try {
            s1 = engimon1.breed(engimon2);
            assertEquals(false, s1 == null);
        } catch (EngimonStateException e) {
            assert(false);
        }
    }

    // @Test
    // @DisplayName("Test equals ")
    // void testequals() {
    // try {
    // Engimon engimon1 = new Engimon(species1);
    // Engimon engimon2 = new Engimon(species2);
    // Engimon engimon3 = new Engimon(species1, engimon1, engimon2);
    // Engimon engimon4 = new Engimon(species1, engimon1, engimon2);
    // Engimon engimon5 = new Engimon(species2, engimon1, engimon3);
    // Engimon engimon6 = new Engimon(species2, engimon1, engimon2);
    // // Cek parent
    // assertEquals(false, engimon3.equals(engimon4));
    // assertEquals(false, engimon4.equals(engimon5));
    // // Cek exp
    // engimon3.addExperience(100);
    // assertEquals(false, engimon3.equals(engimon4));
    // engimon4.addExperience(100);
    // // Cek life
    // engimon3.reduceLife();
    // assertEquals(false, engimon3.equals(engimon4));
    // engimon4.reduceLife();
    // // Cek skill
    // engimon3.addSkill(skill2);
    // assertEquals(false, engimon3.equals(engimon4));
    // // Cek species
    // assertEquals(false, engimon3.equals(engimon6));
    // } catch (EngimonDeadException e) {
    // e.getMessage();
    // } catch (EngimonStateException e) {
    // e.getMessage();
    // }
    // }

    @Test
    @DisplayName("Test getPower ")
    void testgetPower() {
        try {
            Engimon engimon1 = new Engimon(species1);
            Engimon engimon3 = new Engimon(species3);
            assertEquals(0D, engimon1.getPower(engimon3));
            engimon1.addSkill(skill1);
            assertEquals(50D, engimon1.getPower(engimon3));
        } catch (EngimonStateException e) {
            e.getMessage();
        }
    }
}
