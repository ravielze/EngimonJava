package com.engimon;

import com.engimon.entity.ElementTable;
import com.engimon.entity.engimon.Species;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.SkillNotFound;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestElementTable {
    
    @Test
    @DisplayName("Test ElementTable - getMultiplier(Element attack, Element defense)")
    void testgetMultiplier(){
        assertEquals(1D, ElementTable.getMultiplier(Element.FIRE, Element.ELECTRIC));
        assertEquals(2D, ElementTable.getMultiplier(Element.WATER, Element.FIRE));
        assertEquals(0D, ElementTable.getMultiplier(Element.WATER, Element.NONE));
        assertEquals(0D, ElementTable.getMultiplier(Element.NONE, Element.FIRE));
        assertEquals(1D, ElementTable.getMultiplier(Element.ICE, Element.ICE));
    }
}
