package com.engimon.entity.engimon;

import com.engimon.entity.enums.Element;

import org.jetbrains.annotations.NotNull;

public class ElementWrapper extends Elementum{

    public ElementWrapper(@NotNull Element firstElement){
        super(firstElement);

    }

    public ElementWrapper(@NotNull Element firstElement, @NotNull Element secondElement){
        super(firstElement, secondElement);
    }
    
}
