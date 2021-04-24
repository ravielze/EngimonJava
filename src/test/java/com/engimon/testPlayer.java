package com.engimon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.engimon.entity.Player;
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

public class testPlayer {
    
    private Skill skill1 = new Skill(Element.ELECTRIC, 1, "SambarListrik", 50.0D);
    private Skill skill2 = new Skill(Element.ELECTRIC, 2, "KilatListrik", 50.0D);
    private Species species1;
    private Species species2;
    {
        try {
            species1 = new Species(Element.ELECTRIC, 101, 1, "Pikaco", new String[] { "sheeshhhh", "pikapika" });
            species2 = new Species(Element.ELECTRIC, 102, 2, "Electabuz", new String[] { "buzz", "buzbuzbuzz" });
        } 
        catch (SkillNotFound ignored) {
        }
    }
    private Engimon engimon1 = new Engimon(species1);

    @Test
    @DisplayName("Test constructor Player")
    void testkostruktorplayer(){
        try {
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 3));
            assertEquals(false, p1 == null);
        }
        catch (CellException e){
            
        }
    }

    @Test
    @DisplayName("Test switchEngimon")
    void testswitchEngimon(){
        try {
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 3));
            p1.switchEngimon(engimon2)
            assertEquals(engimon2, p1.activeEngimon);
        }
        catch (CellException e){
        }
    }

    @Test
    @DisplayName("Test getActiveEngimon")
    void testgetActiveEngimon(){
        try{
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 3));
            assertEquals(engimon1, p1.getActiveEngimon());
        }
        catch (CellException e){
            
        }
    }

    @Test
    @DisplayName("Test move")
    void testmove(){
        try{
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 1));
            p1.move(Direction.NORTH);
            assertEquals(p1, map.getCell(2, 3).getOccupier());
        }
        catch (CellException e){
            
        }
    }

    @Test
    @DisplayName("Test getEngimons")
    void testgetEngimons(){
        try{
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 3));
            assertEquals(engimon1, p1.getEngimons());
            // Blom yakin saia
        }
        catch (CellException e){
        }
    }

    @Test
    @DisplayName("Test getItems")
    void testgetItems(){
        try{
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 3));
            //TODO 
        }
        catch (CellException e){
        }
    }

    @Test
    @DisplayName("Test battle")
    void testbattle(){
        try{
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 3));
            //TODO 
        }
        catch (CellException e){
        }
    }
}
