package com.engimon.entity.enums;

import com.engimon.map.biome.Cell;

public enum Direction {

    WEST(1, 0), EAST(-1, 0), NORTH(0, 1), SOUTH(0, -1);

    private final int x;
    private final int y;

    private Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public static Direction getDirection(Cell from, Cell to) {
        int x = Math.min(Math.max(to.getX() - from.getX(), -1), 1);
        int y = Math.min(Math.max(to.getY() - from.getY(), -1), 1);
        for (Direction d : Direction.values()) {
            if (d.getX() == x && d.getY() == y) {
                return d;
            }
        }
        y = 0;
        for (Direction d : Direction.values()) {
            if (d.getX() == x && d.getY() == y) {
                return d;
            }
        }
        return Direction.NORTH;
    }

}
