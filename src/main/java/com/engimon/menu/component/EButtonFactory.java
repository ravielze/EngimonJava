package com.engimon.menu.component;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import java.awt.Dimension;

public class EButtonFactory {
    public static EButton CreateDefaultFontButton(String displayText, Color backgroundColor, MouseAdapter event) {
        EButton button = new EButton(displayText, event);
        button.setBackground(backgroundColor);
        return button;
    }

    public static EButton CreateDefaultFontButton(String displayText, Color backgroundColor, int width, int height, MouseAdapter event) {
        EButton button = new EButton(displayText, event);
        button.setBackground(backgroundColor);
        button.setPreferredSize(new Dimension(width, height));
        return button;
    }
}
