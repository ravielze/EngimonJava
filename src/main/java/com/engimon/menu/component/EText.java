package com.engimon.menu.component;

import javax.swing.JLabel;

import com.engimon.menu.EComponent;
import java.awt.FlowLayout;

import org.jetbrains.annotations.NotNull;

public class EText extends JLabel implements EComponent {

    public EText(@NotNull String displayText) {
        super(displayText);
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

}
