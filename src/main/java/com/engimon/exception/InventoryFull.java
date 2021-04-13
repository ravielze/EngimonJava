package com.engimon.exception;

public class InventoryFull extends IllegalStateException {

    private static final long serialVersionUID = 1961475273542405731L;

    public InventoryFull() {
        super("Inventory is full.");
    }

}
