package com.engimon.entity;

import java.util.List;
import java.util.stream.Collectors;

import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.enums.Direction;
import com.engimon.entity.skill.SkillItem;
import com.engimon.exception.CellException;
import com.engimon.inventory.Inventory;
import com.engimon.inventory.Storable;
import com.engimon.map.Map;
import com.engimon.map.biome.Cell;
import com.engimon.map.biome.LivingEntity;

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

    public void switchEngimon(@NotNull Engimon eng) {
        inventory.add(activeEngimon);
        if (inventory.contains(eng)) {
            activeEngimon = eng;
            inventory.remove(eng);
        }
    }

    @NotNull
    public Engimon getActiveEngimon() {
        return this.activeEngimon;
    }

    // TODO active engimon follow
    public void move(@NotNull Direction dir) throws CellException {
        int x = currentCell.getX();
        int y = currentCell.getY();
        Cell target = Map.getInstance().getCell(x + dir.getX(), y + dir.getY());
        currentCell.move(target);
        this.currentCell = target;
    }

    @NotNull
    public List<Engimon> getEngimons() {
        return this.inventory.stream().filter(Engimon.class::isInstance).map(Engimon.class::cast).sorted()
                .collect(Collectors.toList());
    }

    @NotNull
    public List<SkillItem> getItems() {
        return this.inventory.stream().filter(SkillItem.class::isInstance).map(SkillItem.class::cast).sorted()
                .collect(Collectors.toList());
    }

}
