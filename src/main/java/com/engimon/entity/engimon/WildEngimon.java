package com.engimon.entity.engimon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.jetbrains.annotations.NotNull;

public class WildEngimon extends Engimon {

    private static final long serialVersionUID = -4173057657086613937L;

    public WildEngimon(@NotNull Species species) {
        super(species);
        this.life = 1;
    }

    public WildEngimon() {
        super();
    }

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

}
