package com.engimon.entity;

import java.util.List;
import java.util.stream.Collectors;

import com.engimon.entity.engimon.ActiveEngimon;
import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.WildEngimon;
import com.engimon.entity.enums.Direction;
import com.engimon.entity.skill.SkillItem;
import com.engimon.exception.CellException;
import com.engimon.exception.EngimonDeadException;
import com.engimon.exception.InventoryFull;
import com.engimon.exception.PlayerException;
import com.engimon.exception.CellException.ErrorCause;
import com.engimon.exception.PlayerException.PlayerError;
import com.engimon.inventory.Inventory;
import com.engimon.inventory.Storable;
import com.engimon.map.Map;
import com.engimon.map.Moveable;
import com.engimon.map.biome.Cell;
import com.engimon.map.biome.LivingEntity;

import org.jetbrains.annotations.NotNull;

public class Player implements LivingEntity, Moveable {

    private ActiveEngimon activeEngimon;
    private Inventory<Storable> inventory;
    private Cell currentCell;

    public Player(@NotNull Engimon firstEngimon, @NotNull Cell spawnPoint, @NotNull Cell engimonSpawnPoint) {
        this.activeEngimon = new ActiveEngimon(firstEngimon, engimonSpawnPoint);
        this.inventory = new Inventory<>(30);
        this.currentCell = spawnPoint;
        spawnPoint.setOccupier(this);
    }

    public void switchEngimon(@NotNull Engimon eng) {
        ActiveEngimon tempActiveEngimon = this.activeEngimon;
        if (inventory.contains(eng)) {
            activeEngimon = new ActiveEngimon(eng, tempActiveEngimon.getCell());
            inventory.remove(eng);
        }
        if (activeEngimon != null)
            inventory.add(new Engimon(tempActiveEngimon));
    }

    @NotNull
    public ActiveEngimon getActiveEngimon() {
        return this.activeEngimon;
    }

    public void move(@NotNull Direction dir) throws CellException {
        int x = currentCell.getX();
        int y = currentCell.getY();
        Cell target = Map.getInstance().getCell(x + dir.getX(), y + dir.getY());
        try {
            currentCell.transferEntity(target);
            Direction d = Direction.getDirection(this.activeEngimon.getCell(), currentCell);
            this.activeEngimon.move(d);
            this.currentCell = target;
        } catch (CellException ex) {
            if (ex.getErrorCause() == ErrorCause.CELL_OCCUPIED_BY_ACTIVE_ENGIMON) {
                this.swapPosition();
            } else {
                throw ex;
            }
        }
    }

    public void swapPosition() {
        Cell engimonCell = this.activeEngimon.getCell();
        this.activeEngimon.reposition(this.currentCell);
        engimonCell.setOccupier(this);
        this.currentCell = engimonCell;
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

    public void battle(WildEngimon we) throws EngimonDeadException, PlayerException, InventoryFull {
        if (activeEngimon == null) {
            throw new PlayerException(PlayerError.NO_ACTIVE_ENGIMON);
        }
        double enemyPower = we.getPower(activeEngimon);
        double selfPower = activeEngimon.getPower(we);
        if (enemyPower > selfPower) {
            activeEngimon.reduceLife();
        } else {
            activeEngimon.addExperience(we.getLevel() * 35);
            try {
                we.reduceLife();
            } catch (EngimonDeadException ex) {
                if (ex.getEngimon().equals(we)) {
                    we.kill();
                    inventory.add(new Engimon(we));
                }
            }
        }
    }

}
