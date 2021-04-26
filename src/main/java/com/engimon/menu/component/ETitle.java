package com.engimon.menu.component;

import java.awt.Font;

import javax.swing.JLabel;

public class ETitle extends ERow {
    public ETitle(String text) {
        JLabel title = new JLabel(text);
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        add(title);
    }
}
