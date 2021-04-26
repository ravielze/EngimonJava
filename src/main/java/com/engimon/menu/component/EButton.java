package com.engimon.menu.component;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.engimon.menu.EComponent;

public class EButton extends JButton implements EComponent {

    public EButton(String displayText, MouseAdapter event) {
        super(displayText);
        addMouseListener(event);
        setFont(new Font("Arial", Font.PLAIN, 20));

    }

    public EButton(String displayText, int textSize, MouseAdapter event) {
        super(displayText);
        // this.setBorder(BorderFactory.createLineBorder(Color.black));
        addMouseListener(event);
        setPreferredSize(new Dimension(150, 50));
        setFont(new Font("Arial", Font.PLAIN, textSize));
    }

    public EButton(String displayText, int textSize, int width, int height, MouseAdapter event) {
        super(displayText);
        // this.setBorder(BorderFactory.createLineBorder(Color.black));
        addMouseListener(event);
        setPreferredSize(new Dimension(width, height));
        setFont(new Font("Arial", Font.PLAIN, textSize));
    }

    public void setPadding(int x, int y) {
        setBorder(BorderFactory.createEmptyBorder(y, x, y, x));
    }

}
