package com.engimon.gui;

import java.awt.*;
import javax.swing.*;


public class Map extends JPanel implements Screen {
    private GUIMediator mediator;
    @Override
    public void setMediator (GUIMediator m) {
        this.mediator = m;
    }

    @Override 
    public String getName() {
        return "Start Page";
    }

    public Map() {
        super();
        prepareGui();
    }

    private void prepareGui() {
        JButton button = new JButton("Hello world This is map");

        this.add(button);

    }
}
