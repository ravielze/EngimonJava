package com.engimon.entity.enums;

public enum Element {

    NONE(999999), FIRE(0), WATER(1), ELECTRIC(2), GROUND(3), ICE(4);

    private final int index;

    private Element(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
