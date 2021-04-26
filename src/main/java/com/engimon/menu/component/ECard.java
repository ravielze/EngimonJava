package com.engimon.menu.component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class ECard extends EColumn {
    public ECard(String toShow, Color bgColor) {
        JLabel label = new JLabel("<html>" + toShow.replaceAll("\n", "<br />") + "</html>");
        label.setOpaque(true);
        label.setBackground(bgColor);
        label.setBorder(BorderFactory.createLineBorder(bgColor, 30));
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        add(label);
    }

    public ECard(String toShow, Color bgColor, int width, int height) {
        this(toShow, bgColor);
        setPreferredSize(new Dimension(width, height));
    }
}
