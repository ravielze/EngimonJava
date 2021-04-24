package com.engimon.gui;

import java.awt.*;
import javax.swing.*;


public class Map extends JPanel implements Screen {
    private GUIMediator mediator;
    private final int size = 20;
    private Cell[][] grid;
    @Override
    public void setMediator (GUIMediator m) {
        this.mediator = m;
    }

    @Override 
    public String getName() {
        return "Map";
    }

    public Map() {
        super();
        this.grid = new Cell[size][size];
        prepareGui();
    }
    
    private void prepareGui() {
        setMenu();
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);


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

        this.add(row2);
    }
    
    private void setMenu() {
        String[] labels = {"Inventory", "Breeding", "Save", "Help"};
        JPanel row = new JPanel();
        row.setLayout(new FlowLayout(FlowLayout.LEFT));

        for (String label : labels) {
            Button button = new Button(label);
            button.setPadding(10, 20);
            row.add(button);
        }
        this.add(row);
    }
}
