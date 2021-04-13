package com.engimon.map.biome;

import com.engimon.entity.Elementum;
import com.engimon.entity.LivingEntity;
import com.engimon.entity.Player;
import com.engimon.entity.WildEngimon;
import com.engimon.exception.CellException;
import com.engimon.exception.CellException.ErrorCause;

public abstract class Cell {

    private LivingEntity occupied;

    protected abstract boolean allowPass(Elementum el);

    public boolean allowPass(LivingEntity entity) {
        if (entity instanceof WildEngimon) {
            WildEngimon eng = (WildEngimon) entity;
            return allowPass(eng.getSpecies());
        }
        return true;
    }

    public boolean isOccupied() {
        return this.occupied != null;
    }

    private void setOccupier(LivingEntity entity) {
        this.occupied = entity;
    }

    public LivingEntity getOccupier() {
        return this.occupied;
    }

    public void move(Cell other) throws CellException {
        if (this.occupied == null) {
            throw new CellException(ErrorCause.CELL_EMPTY);
        }
        if (other.isOccupied()) {
            LivingEntity occupier = other.getOccupier();
            if (occupier instanceof Player) {
                throw new CellException(ErrorCause.CELL_OCCUPIED_BY_PLAYER);
            } else {
                throw new CellException(ErrorCause.CELL_OCCUPIED_BY_OTHER);
            }
        }
        other.setOccupier(this.occupied);
        this.setOccupier(null);
    }

}
