package com.engimon.entity.engimon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.engimon.entity.Spawner;
import com.engimon.entity.enums.Direction;
import com.engimon.exception.CellException;
import com.engimon.exception.EngimonStateException;
import com.engimon.exception.EngimonStateException.StateError;
import com.engimon.map.Map;
import com.engimon.map.Moveable;
import com.engimon.map.biome.Cell;
import com.engimon.map.biome.LivingEntity;

import org.jetbrains.annotations.NotNull;

public class WildEngimon extends Engimon implements LivingEntity, Moveable {

    private static final long serialVersionUID = -4173057657086613937L;
    private Cell currentCell;

    public WildEngimon(@NotNull Species species, int level, @NotNull Cell spawnPoint) throws EngimonStateException {
        super(species);
        if (!spawnPoint.allowSpawn(this)) {
            throw new EngimonStateException(this, StateError.ENGIMON_CANT_SPAWN);
        }
        this.currentCell = spawnPoint;
        spawnPoint.setOccupier(this);
        this.level = level;
        this.life = 1;
    }

    public WildEngimon() {
        super();
        // Constructor for serializable
    }

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

    @Override
    public void move(Direction dir) throws CellException {
        int x = currentCell.getX();
        int y = currentCell.getY();
        Cell target = Map.getInstance().getCell(x + dir.getX(), y + dir.getY());
        currentCell.transferEntity(target);
        this.currentCell = target;
    }

    public void kill() {
        this.currentCell.setOccupier(null);
        this.currentCell = null;
        Spawner.getInstance().reducePopulation();
    }

}
