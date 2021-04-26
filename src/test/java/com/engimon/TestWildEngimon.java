package com.engimon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.engimon.entity.engimon.Species;
import com.engimon.entity.engimon.WildEngimon;
import com.engimon.entity.enums.Direction;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.CellException;
import com.engimon.exception.EngimonStateException;
import com.engimon.exception.SkillNotFound;
import com.engimon.map.Map;
import com.engimon.map.biome.cells.GrasslandCell;

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
            WildEngimon wildEngimon = new WildEngimon(species1, 10, new GrasslandCell(2, 2));
            assertEquals(false, wildEngimon == null);
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }
    @Test
    @DisplayName("Test move")
    void testmove(){
        try {
            Map map = new Map(20);
            WildEngimon wildEngimon = new WildEngimon(species1, 10, map.getCell(2, 2));
            wildEngimon.move(Direction.NORTH);
            assertEquals(wildEngimon, map.getCell(2, 3).getOccupier());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
        catch (CellException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test kill")  
    void testkill(){
        try {
            Map map = new Map(20);
            WildEngimon wildEngimon = new WildEngimon(species1, 10, map.getCell(2, 2));
            wildEngimon.kill();
            assertEquals(null, map.getCell(2, 2).getOccupier());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
        catch (CellException e){
            e.getMessage();
        }
    }  
}
