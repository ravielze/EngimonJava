package com.engimon.map.biome;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.engimon.entity.Player;
import com.engimon.entity.engimon.Elementum;
import com.engimon.entity.engimon.WildEngimon;
import com.engimon.exception.CellException;
import com.engimon.exception.CellException.ErrorCause;

public abstract class Cell implements Serializable {

    private static final long serialVersionUID = -6351841280611348432L;

    private int x, y;

    private CellOccupier occupied;

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

    public Cell() {
        // Constructor for Serializable Access
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

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

    private void setOccupier(CellOccupier entity) {
        this.occupied = entity;
    }

    public void setOccupier(Player player) {
        this.occupied = player;
    }

    public CellOccupier getOccupier() {
        return this.occupied;
    }

    public void move(Cell other) throws CellException {
        if (this.occupied == null) {
            throw new CellException(ErrorCause.CELL_EMPTY);
        }
        if (other.isOccupied()) {
            CellOccupier occupier = other.getOccupier();
            if (occupier instanceof Player) {
                throw new CellException(ErrorCause.CELL_OCCUPIED_BY_PLAYER);
            } else if (occupier instanceof LivingEntity) {
                throw new CellException(ErrorCause.CELL_OCCUPIED_BY_OTHER);
            } else {
                throw new CellException(ErrorCause.CELL_OCCUPIED_BY_OBSTACLE);
            }
        }
        if (this.occupied instanceof LivingEntity) {
            other.setOccupier(this.occupied);
            this.setOccupier(null);
        }
    }

}
