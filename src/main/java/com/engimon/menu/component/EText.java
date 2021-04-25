package com.engimon.menu.component;

import javax.swing.JLabel;

import com.engimon.menu.EComponent;
import com.engimon.menu.EPage;
import java.awt.FlowLayout;

import org.jetbrains.annotations.NotNull;

public class EText extends EComponent {

    private JLabel text;

    public EText(@NotNull EPage page, @NotNull String displayText) {
        super(page);
        text = new JLabel(displayText);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(text);
    }

    public void setText(String displayText) {
        text.setText(displayText);
    }
}
