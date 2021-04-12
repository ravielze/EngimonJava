package com.engimon.entity;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Species extends Elementum {

    public Species(Element firstElement, String name, String[] message) {
        super(firstElement);
        this.name = name;
        this.message = new ArrayList<String>();
        if (message.length > 0) {
            for (String each : message) {
                if (each == null)
                    continue;
                if (each.length() == 0)
                    continue;
                this.message.add(each);
            }
        }
    }

    public Species(Element firstElement, Element secondElement, String name, String[] message) {
        super(firstElement, secondElement);
        this.name = name;
        this.message = new ArrayList<String>();
        if (message.length > 0) {
            for (String each : message) {
                if (each == null)
                    continue;
                if (each.length() == 0)
                    continue;
                this.message.add(each);
            }
        }
    }

    private String name;
    private List<String> message;

    public String getName() {
        return this.name;
    }

    public String interact() {
        SecureRandom rnd = new SecureRandom();
        return message.get(rnd.nextInt(message.size()));
    }

}
