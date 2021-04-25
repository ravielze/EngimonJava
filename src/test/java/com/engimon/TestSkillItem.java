package com.engimon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.Species;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.entity.skill.SkillItem;
import com.engimon.exception.EngimonStateException;
import com.engimon.exception.SkillNotFound;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSkillItem {
    @Test
    @DisplayName("Test SkillItem - kostruktor")
    void testgetSkillList(){
        Skill skillE = new Skill(Element.ELECTRIC, 101, "Lightning Stiletto", 84);
        SkillItem skillItem1 = new SkillItem(skillE);
        assertEquals(false, skillItem1 == null);
    }
    @Test
    @DisplayName("Test SkillItem - getAmount()")
    void testgetAmount(){
        Skill skillE = new Skill(Element.ELECTRIC, 101, "Lightning Stiletto", 84);
        SkillItem skillItem1 = new SkillItem(skillE);
        assertEquals(0, skillItem1.getAmount());
    }
    @Test
    @DisplayName("Test SkillItem - getName()")
    void testgetName(){
        Skill skillE = new Skill(Element.ELECTRIC, 101, "Lightning Stiletto", 84);
        SkillItem skillItem1 = new SkillItem(skillE);
        assertEquals("Lightning Stiletto", skillItem1.getName());
    }
    @Test
    @DisplayName("Test SkillItem - learn(@NotNull Engimon eng)")
    void testlearn1(){
        try {
            Species species1 = new Species(Element.ELECTRIC, 101, 102, "Keqingmon", new String[] {"nowhere to hide"});
            Engimon engimon1 = new Engimon(species1);
            Skill skillE = new Skill(Element.ELECTRIC, 101, "Lightning Stiletto", 84);
            SkillItem skillItem1 = new SkillItem(skillE);
            skillItem1.learn(engimon1);
            assertEquals(-1, skillItem1.getAmount());
        } catch (SkillNotFound e) {
            assert(false);
        } catch (EngimonStateException e) {
            assert(false);
        }
    }
    @Test
    @DisplayName("Test SkillItem - learn(@NotNull Engimon eng, int index)")
    void testlearn2(){
        try {
            Species species1 = new Species(Element.ELECTRIC, 101, 102, "Keqingmon", new String[] {"nowhere to hide"});
            Engimon engimon1 = new Engimon(species1);
            Skill skillE = new Skill(Element.ELECTRIC, 101, "Lightning Stiletto", 84);
            SkillItem skillItem1 = new SkillItem(skillE);
            Skill skillQ = new Skill(Element.ELECTRIC, 102, "Starward Sword", 188);
            SkillItem skillItem2 = new SkillItem(skillQ);
            skillItem1.learn(engimon1);
            skillItem2.learn(engimon1, 101);
            assertEquals(-1, skillItem1.getAmount());
            assertEquals(-1, skillItem2.getAmount());
            assertEquals(engimon1.getAllSkills().size(), 1);
        } catch (SkillNotFound e) {
            assert(false);
        } catch (EngimonStateException e) {
            assert(false);
        }
    }
    @Test
    @DisplayName("Test SkillItem - equals(Object o)")
    void testequals(){
        Skill skillE = new Skill(Element.ELECTRIC, 101, "Lightning Stiletto", 84);
        SkillItem skillItem1 = new SkillItem(skillE);
        SkillItem skillItem3 = new SkillItem(skillE);
        Skill skillQ = new Skill(Element.ELECTRIC, 102, "Starward Sword", 188);
        SkillItem skillItem2 = new SkillItem(skillQ);
        assertEquals(true, skillItem1.equals(skillItem1));
        assertEquals(false, skillItem1.equals(null));
        assertEquals(false, skillItem1.equals(skillE));
        assertEquals(false, skillItem1.equals(skillItem2));
        assertEquals(true, skillItem1.equals(skillItem3));
    }
    @Test
    @DisplayName("Test SkillItem - toString()")
    void testtoString(){
        Skill skillE = new Skill(Element.ELECTRIC, 101, "Lightning Stiletto", 84);
        SkillItem skillItem1 = new SkillItem(skillE);
        assertEquals("Lightning Stiletto x0", skillItem1.toString());
    }
    @Test
    @DisplayName("Test SkillItem - compareTo(@NotNull SkillItem o)")
    void testcompareTo(){
        Skill skillE = new Skill(Element.ELECTRIC, 101, "Lightning Stiletto", 84);
        SkillItem skillItem1 = new SkillItem(skillE);
        SkillItem skillItem3 = new SkillItem(skillE);
        Skill skillQ = new Skill(Element.ELECTRIC, 102, "Starward Sword", 188);
        SkillItem skillItem2 = new SkillItem(skillQ);
        assertEquals(0, skillItem1.compareTo(skillItem3));
        assertEquals(1, skillItem1.compareTo(skillItem2));
        assertEquals(-1, skillItem2.compareTo(skillItem1));
    }
}
