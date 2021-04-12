package com.engimon.entity;

public abstract class Elementum {

    private Element firstElement;
    private Element secondElement;

    public Elementum(Element firstElement){
        if (firstElement == Element.NONE){
            throw new IllegalArgumentException("First element cannot be none.");
        }
        this.firstElement = firstElement;
        this.secondElement = Element.NONE;

    }
    public Elementum(Element firstElement, Element secondElement){
        if (firstElement == Element.NONE){
            throw new IllegalArgumentException("First element cannot be none.");
        }
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }


    public int getElements(){
        return 1 + (this.secondElement == Element.NONE ? 0 : 1);
    }

    public Element getFirstElement(){
        return this.firstElement;
    }

    public Element getSecondElement(){
        return this.secondElement;
    }
    
}
