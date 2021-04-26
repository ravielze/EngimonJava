package com.engimon.inventory;

import java.util.Collection;
import java.util.LinkedList;

import com.engimon.exception.InventoryFull;

public class Inventory<T> extends LinkedList<T> {

    private static final long serialVersionUID = 821082348028293622L;
    private int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean add(T e) {
        if (size() + 1 > capacity) {
            throw new InventoryFull();
        }
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (size() + c.size() > capacity) {
            throw new InventoryFull();
        }
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (size() + c.size() > capacity) {
            throw new InventoryFull();
        }
        return super.addAll(size(), c);
    }

    @Override
    public void add(int index, T element) {
        if (size() + 1 > capacity) {
            throw new InventoryFull();
        }
        super.add(index, element); 
    }

    @Override
    public String toString() {
        return String.format("Inventory %d/%d", size(), capacity);
    }
}
