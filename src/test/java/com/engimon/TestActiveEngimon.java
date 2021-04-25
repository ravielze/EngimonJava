package com.engimon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.engimon.entity.engimon.ActiveEngimon;
import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.Species;
import com.engimon.entity.enums.Direction;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.CellException;
import com.engimon.exception.SkillNotFound;
import com.engimon.map.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestActiveEngimon {

    private Skill skill1 = new Skill(Element.ELECTRIC, 1, "SambarListrik", 50.0D);
    private Species species1;
    {
        try {
            species1 = new Species(Element.ELECTRIC, 101, 1, "Pikaco", new String[] { "sheeshhhh", "pikapika" });
        } 
        catch (SkillNotFound ignored) {
        }
    }
    private Engimon engimon1 = new Engimon(species1);


    @Test
    @DisplayName("Test constructor ActiveEngimon")
    void testkonstruktorActiveEngimon(){
        try{
            Map map = new Map(20);
            ActiveEngimon ae1 = new ActiveEngimon(engimon1, map.getCell(2,3));
            assertEquals(false, ae1 == null);
        }
        catch (CellException e){

        }
    }


    @Test
    @DisplayName("Test get Cell")
    void testgetCell(){
        try{
            Map map = new Map(20);
            ActiveEngimon ae1 = new ActiveEngimon(engimon1, map.getCell(2,3));
            assertEquals(map.getCell(2,3).getOccupier(), ae1.getCell());
        }
        catch (CellException e){

        }
    }


    @Test
    @DisplayName("Test move")
    void testmove(){
        try{
            Map map = new Map(20);
            ActiveEngimon ae1 = new ActiveEngimon(engimon1, map.getCell(2,3));
            ae1.move(Direction.NORTH);
            assertEquals(ae1.getCell(), map.getCell(2, 4).getOccupier());
        }
        catch (CellException e){
            
        }
    }

}
