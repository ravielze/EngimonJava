package com.engimon.menu.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.engimon.common.ResourceReader;
import com.engimon.menu.EComponent;

import org.jetbrains.annotations.NotNull;

public class EImage extends JLabel implements EComponent {
    
    public EImage(@NotNull String fileName, int width, int height) {
        super(new ImageIcon(ResourceReader.getImage(fileName, width, height)), JLabel.CENTER);
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public EImage(@NotNull Image image, int width, int height) {
        super(new ImageIcon(image));
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }

}
