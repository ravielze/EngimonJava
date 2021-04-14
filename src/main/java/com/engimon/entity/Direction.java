package com.engimon.entity;

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

}
