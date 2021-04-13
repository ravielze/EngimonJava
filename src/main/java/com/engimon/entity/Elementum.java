package com.engimon.entity;

public abstract class Elementum {

    private Element firstElement;
    private Element secondElement;

    public Elementum(Element firstElement) throws IllegalArgumentException {
        if (firstElement == Element.NONE) {
            throw new IllegalArgumentException("First element cannot be none.");
        }
        this.firstElement = firstElement;
        this.secondElement = Element.NONE;

    }

    public Elementum(Element firstElement, Element secondElement) throws IllegalArgumentException {
        if (firstElement == Element.NONE) {
            throw new IllegalArgumentException("First element cannot be none.");
        }
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public int getElements() {
        return 1 + (this.secondElement == Element.NONE ? 0 : 1);
    }

    public Element getFirstElement() {
        return this.firstElement;
    }

    public Element getSecondElement() {
        return this.secondElement;
    }

    public boolean isOneOf(Element el) {
        return el == this.firstElement || el == this.secondElement;
    }

    public Element getMajorElement(Elementum elementum) {
        // TODO tunggu ada mapping element
        return Element.NONE;
    }

    public Element getMinorElement(Elementum elementum) {
        // TODO tunggu ada mapping element
        return Element.NONE;
    }

    @Override
    public String toString() {
        if (getElements() == 1) {
            return firstElement.toString();
        }
        return String.format("%s-%s", firstElement.toString(), secondElement.toString());
    }

}
