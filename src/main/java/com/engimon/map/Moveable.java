package com.engimon.map;

import com.engimon.entity.enums.Direction;
import com.engimon.exception.CellException;

public interface Moveable {

    public void move(Direction dir) throws CellException;
    
}
