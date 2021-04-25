package com.engimon.gui;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory; 

public class Button extends JPanel {
    private JLabel placeholder;
    public Button(String label) {
        super();
        this.placeholder = new JLabel(label);
        this.add(placeholder);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void setPadding(int x, int y) {
        placeholder.setBorder(BorderFactory.createEmptyBorder(y, x, y, x));
    }
    
}
