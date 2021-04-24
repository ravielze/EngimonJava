package com.engimon.gui;

import java.awt.*;
import javax.swing.*;


public class Map extends JPanel implements Screen {
    private GUIMediator mediator;
    private final int size = 30;
    private Cell[][] grid;
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
        this.grid = new Cell[size][size];
        prepareGui();
    }

    private void prepareGui() {
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);

        JPanel row1 = new JPanel();
        row1.setLayout(new FlowLayout(FlowLayout.LEFT));
        row1.add(new JLabel("Nanti disini bakal ada menu"));


        JPanel row2 = new JPanel();
        row2.setLayout(new BoxLayout(row2, BoxLayout.Y_AXIS));
        for (int i = 0; i < size; i++) {
            JPanel row = new JPanel();
            row.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
                row.add(grid[i][j]);
            }
            row2.add(row);
        }

        this.add(row1);
        this.add(row2);


    }
}
