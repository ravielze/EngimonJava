package com.engimon;

import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSkill {
    @Test
    @DisplayName("Test Skill - getSkillList()")
    void testgetSkillList(){
        Skill skill = new Skill(Element.FIRE, Element.ELECTRIC, 1, "ThunderBoom", 50.0D);
        assertEquals(skill.getSkillName(), Skill.getSkillList().get(1).getSkillName());
    }

    @Test
    @DisplayName("Test Skill - getSkill(int id)")
    void testgetSkill(){
        Skill skill = new Skill(Element.FIRE, Element.ELECTRIC, 1, "ThunderBoom", 50.0D);
        assertEquals(skill.getSkillName(), Skill.getSkill(1).getSkillName());
    }

    @Test
    @DisplayName("Test Skill - getSkillId()")
    void testgetSkillId(){
        Skill skill = new Skill(Element.FIRE, Element.ELECTRIC, 1, "ThunderBoom", 50.0D);
        assertEquals(1, skill.getSkillId());
    }

    @Test
    @DisplayName("Test Skill - getSkillName()")
    void testgetSkillName(){
        Skill skill = new Skill(Element.FIRE, Element.ELECTRIC, 1, "ThunderBoom", 50.0D);
        assertEquals("ThunderBoom", skill.getSkillName());
    }

    @Test
    @DisplayName("Test Skill - getBasePower()")
    void testgetBasePower(){
        Skill skill = new Skill(Element.FIRE, Element.ELECTRIC, 1, "ThunderBoom", 50.0D);
        assertEquals(50.0D, skill.getBasePower());
    }

    @Test
    @DisplayName("Test Skill - getPower()")
    void testgetPower(){
        Skill skill = new Skill(Element.FIRE, Element.ELECTRIC, 1, "ThunderBoom", 50.0D);
        assertEquals(50.0D, skill.getPower());
    }

    @Test
    @DisplayName("Test Skill - getMasteryLevel()")
    void testgetMasteryLevel(){
        Skill skill = new Skill(Element.FIRE, Element.ELECTRIC, 1, "ThunderBoom", 50.0D);
        assertEquals(1, skill.getMasteryLevel());
    }

    @Test
    @DisplayName("Test Skill - addMasteryLevel()")
    void testaddMasteryLevel(){
        Skill skill = new Skill(Element.FIRE, Element.ELECTRIC, 1, "ThunderBoom", 50.0D);
        skill.addMasteryLevel();
        assertEquals(2, skill.getMasteryLevel());
    }

    @Test
    @DisplayName("Test Skill - equals(Object o)")
    void testequals(){
        Skill skill1 = new Skill(Element.FIRE, Element.ELECTRIC, 1, "ThunderBoom", 50.0D);
        Skill skill2 = new Skill(Element.FIRE, Element.ELECTRIC, 1, "ThunderBoom", 50.0D);
        assertEquals(true, skill1.equals(null));
        assertEquals(true, skill1.equals(skill1));
        assertEquals(false, skill1.equals(1));
        assertEquals(true, skill1.equals(skill2));
    }

    @Test
    @DisplayName("Test Skill - toString()")
    void testtoString(){
        Skill skill = new Skill(Element.FIRE, Element.ELECTRIC, 1, "ThunderBoom", 50.0D);
        assertEquals("ThunderBoom/FIRE-ELECTRIC/50.00", skill.toString());
    }
}
