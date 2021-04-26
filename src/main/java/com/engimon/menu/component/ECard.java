package com.engimon.menu.component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;

public class ECard extends EColumn {
    public ECard(String toShow, Color bgColor) {
        JLabel label = new JLabel("<html>" + toShow.replaceAll("\n", "<br />") + "</html>");
        label.setOpaque(true);
        label.setBackground(bgColor);
        label.setBorder(BorderFactory.createLineBorder(bgColor, 30));
        add(label);
    }
}
