package com.engimon.entity;

import com.engimon.inventory.Inventory;
import com.engimon.inventory.Storable;
import com.engimon.map.biome.Cell;
import com.engimon.map.biome.LivingEntity;

import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;

public class Player implements LivingEntity {

    private Engimon activeEngimon;
    private Inventory<Storable> inventory;
    private Cell currentCell;

    public Player(@NotNull Engimon firstEngimon, @NotNull Cell spawnPoint) {
        this.activeEngimon = firstEngimon;
        this.inventory = new Inventory<>(30);
        this.currentCell = spawnPoint;
        spawnPoint.setOccupier(this);
    }

    @NotNull
    public String interact() {
        return activeEngimon.interact();
    }

    public void switchEngimon(@NotNull Engimon eng) {
        Validate.notNull(activeEngimon);
    }

    public void move(@NotNull Direction dir) {
    }

}
