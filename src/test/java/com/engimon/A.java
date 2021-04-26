package com.engimon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.engimon.entity.Player;
import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.Species;
import com.engimon.entity.engimon.WildEngimon;
import com.engimon.entity.enums.Direction;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.CellException;
import com.engimon.exception.EngimonDeadException;
import com.engimon.exception.EngimonStateException;
import com.engimon.exception.PlayerException;
import com.engimon.exception.SkillNotFound;
import com.engimon.map.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class A {

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
    @DisplayName("Test constructor Player")
    void testkostruktorplayer() {
        try {
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 3));
            assertEquals(false, p1 == null);
        } catch (CellException e) {

        }
    }

    @Test
    @DisplayName("Test switchEngimon")
    void testswitchEngimon() {
        try {
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 3));
            p1.switchEngimon(engimon2);
            assertEquals(engimon2, p1.getActiveEngimon());
        } catch (CellException e) {
        }
    }

    @Test
    @DisplayName("Test getActiveEngimon")
    void testgetActiveEngimon() {
        try {
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 3));
            assertEquals(engimon1, p1.getActiveEngimon());
        } catch (CellException e) {

        }
    }

    @Test
    @DisplayName("Test move")
    void testmove() {
        try {
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 1));
            p1.move(Direction.NORTH);
            assertEquals(p1, map.getCell(2, 3).getOccupier());
        } catch (CellException e) {

        }
    }

    @Test
    @DisplayName("Test getEngimons")
    void testgetEngimons() {
        try {
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 3));
            assertEquals(1, p1.getEngimons().size());
            assertEquals(engimon1, p1.getEngimons().get(0));
        } catch (CellException e) {
            assert (false);
        }
    }

    @Test
    @DisplayName("Test getItems")
    void testgetItems() {
        try {
            Map map = new Map(20);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 3));
            assertEquals(null, p1.getItems());
        } catch (CellException e) {
            assert (false);
        }
    }

    @Test
    @DisplayName("Test battle")
    void testbattle() {
        Map map = new Map(20);
        try {
            engimon1.addSkill(skill1);
            engimon1.addSkill(skill2);
            engimon1.addExperience(10);
            Player p1 = new Player(engimon1, map.getCell(2, 2), map.getCell(2, 3));
            WildEngimon musuh = new WildEngimon(species1, 2, map.getCell(1, 2));
            p1.battle(musuh);
            assertEquals(map.getCell(1, 2).getOccupier() == null, true);
        } catch (EngimonStateException e) {
            assert (false);
        } catch (PlayerException e) {
            assert (false);
        } catch (CellException e) {
            assert (false);
        } catch (EngimonDeadException e) {
            assert (false);
        }

    }
}
