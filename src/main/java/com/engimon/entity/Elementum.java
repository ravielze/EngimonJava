package com.engimon.entity;

import org.jetbrains.annotations.NotNull;

public abstract class Elementum {

    private Element firstElement;
    private Element secondElement;

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

    @NotNull
    public Element getMajorElement(@NotNull Elementum elementum) {
        // TODO tunggu ada mapping element
        return Element.NONE;
    }

    @NotNull
    public Element getMinorElement(@NotNull Elementum elementum) {
        // TODO tunggu ada mapping element
        return Element.NONE;
    }

    @Override
    @NotNull
    public String toString() {
        if (getElements() == 1) {
            return firstElement.toString();
        }
        return String.format("%s-%s", firstElement.toString(), secondElement.toString());
    }

}
