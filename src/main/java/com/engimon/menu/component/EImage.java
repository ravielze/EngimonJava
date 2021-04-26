package com.engimon.menu.component;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.engimon.common.ResourceReader;
import com.engimon.menu.EComponent;

import org.jetbrains.annotations.NotNull;

public class EImage extends JPanel implements EComponent {

    public EImage(@NotNull String fileName, int width, int height) {
        Image img = ResourceReader.getImage(fileName, width, height);
        JLabel imgLabel = new JLabel(new ImageIcon(img));
        Dimension dim = new Dimension(width, height);
        imgLabel.setPreferredSize(dim);
        imgLabel.setMaximumSize(dim);
        add(imgLabel);
    }

}
