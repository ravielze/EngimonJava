package com.engimon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.engimon.exception.CellException;
import com.engimon.map.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestMap {

    @Test
    @DisplayName("Test Map - setInstance(Map map)")
    void testsetInstance() {
        Map map = new Map(20);
        Map.setInstance(map);
        assertEquals(map, Map.getInstance());
    }

    @Test
    @DisplayName("Test Map - getCell(int x, int y)")
    void testgetCell() {
        try {
            Map.getInstance().getCell(-1, -1);
            assert (false);
        } catch (CellException e) {
            assert (true);
        } finally {
            try {
                assertEquals(Map.getInstance().getCell(1, 1) == null, false);
            } catch (CellException e) {
                assert (false);
            }
        }
    }

    @Test
    @DisplayName("Test Map - getSize()")
    void testgetSize() {
        Map map = Map.getInstance();
        assertEquals(30, map.getSize());
    }

    @Test
    @DisplayName("Test Map - testisInRange(int x, int y)")
    void testisInRange() {
        Map map = Map.getInstance();
        assertEquals(false, map.isInRange(-1, -1));
        assertEquals(false, map.isInRange(-1, 1));
        assertEquals(false, map.isInRange(1, -1));
        assertEquals(true, map.isInRange(1, 1));
    }
}
