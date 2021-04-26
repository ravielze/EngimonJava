package com.engimon.entity.engimon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.engimon.entity.enums.Direction;
import com.engimon.exception.CellException;
import com.engimon.map.Map;
import com.engimon.map.Moveable;
import com.engimon.map.biome.Cell;
import com.engimon.map.biome.LivingEntity;

import org.jetbrains.annotations.NotNull;

public class ActiveEngimon extends Engimon implements Moveable, LivingEntity {
    private Cell currentCell;

    public ActiveEngimon() {
        // Constructor for Serializable
    }

    public ActiveEngimon(@NotNull Engimon engimon, @NotNull Cell lastCell) {
        super(engimon);
        this.currentCell = lastCell;
        lastCell.setOccupier(this);
    }

    public Cell getCell() {
        return currentCell;
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

    public void reposition(Cell cell) {
        cell.setOccupier(this);
        this.currentCell = cell;
    }

}
