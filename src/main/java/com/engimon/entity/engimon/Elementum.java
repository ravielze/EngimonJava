package com.engimon.entity.engimon;

import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.engimon.common.ResourceReader;
import com.engimon.entity.ElementTable;
import com.engimon.entity.enums.Element;

import org.jetbrains.annotations.NotNull;

public abstract class Elementum implements Serializable {

    private static final long serialVersionUID = -692660335192154424L;
    private Element firstElement;
    private Element secondElement;

    public Elementum() {
        // Constructor for Serializable Access
    }

    public Elementum(@NotNull Element firstElement) throws IllegalArgumentException {
        if (firstElement == Element.NONE) {
            throw new IllegalArgumentException("First element cannot be none.");
        }
        this.firstElement = firstElement;
        this.secondElement = Element.NONE;

    }

    public Elementum(@NotNull Element firstElement, @NotNull Element secondElement) throws IllegalArgumentException {
        if (firstElement == Element.NONE) {
            throw new IllegalArgumentException("First element cannot be none.");
        }
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public int getElements() {
        return 1 + (this.secondElement == Element.NONE ? 0 : 1);
    }

    @NotNull
    public Element getFirstElement() {
        return this.firstElement;
    }

    @NotNull
    public Element getSecondElement() {
        return this.secondElement;
    }

    public boolean isOneOf(@NotNull Element el) {
        return el == this.firstElement || el == this.secondElement;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Elementum)) {
            return false;
        }
        Elementum other = (Elementum) o;
        return (other.firstElement == this.firstElement && other.secondElement == this.secondElement)
                || (other.secondElement == this.firstElement && other.firstElement == this.secondElement);
    }

    @NotNull
    public Element getMajorElement(@NotNull Elementum elementum) {

        double maxFirst = ElementTable.getMaxMultiplier(getFirstElement(), elementum);
        double maxSecond = ElementTable.getMaxMultiplier(getSecondElement(), elementum);

        return maxFirst > maxSecond ? getFirstElement() : getSecondElement();
    }

    @NotNull
    public Element getMinorElement(@NotNull Elementum elementum) {

        double maxFirst = ElementTable.getMaxMultiplier(getFirstElement(), elementum);
        double maxSecond = ElementTable.getMaxMultiplier(getSecondElement(), elementum);

        return maxFirst > maxSecond ? getSecondElement() : getFirstElement();
    }

    @Override
    @NotNull
    public String toString() {
        if (getElements() == 1) {
            return firstElement.toString();
        }
        return String.format("%s-%s", firstElement.toString(), secondElement.toString());
    }

    private void readObject(ObjectInputStream inpStream) throws IOException, ClassNotFoundException {
        inpStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        outStream.defaultWriteObject();
    }

    public Image getAura() {
        if (getElements() == 1) {
            return ResourceReader.getImage("Aura/" + firstElement.toString() + ".png", 100, 100);
        } else {
            if (firstElement.getIndex() > secondElement.getIndex()) {
                return ResourceReader.getImage(
                        "Aura/" + secondElement.toString() + "_" + firstElement.toString() + ".png", 100, 100);
            } else {
                return ResourceReader.getImage(
                        "Aura/" + firstElement.toString() + "_" + secondElement.toString() + ".png", 100, 100);
            }
        }
    }

    public Image getElementIcon() {
        if (getElements() == 1) {
            return ResourceReader.getImage("Icons/" + firstElement.toString() + ".png", 50, 50);
        } else {
            if (firstElement.getIndex() > secondElement.getIndex()) {
                return ResourceReader
                        .getImage("Icons/" + secondElement.toString() + "_" + firstElement.toString() + ".png", 50, 50);
            } else {
                return ResourceReader
                        .getImage("Icons/" + firstElement.toString() + "_" + secondElement.toString() + ".png", 50, 50);
            }
        }
    }
}
