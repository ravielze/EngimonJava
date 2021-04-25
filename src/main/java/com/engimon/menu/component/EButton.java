package com.engimon.menu.component;

import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.engimon.menu.EComponent;
import com.engimon.menu.EPage;

import org.jetbrains.annotations.NotNull;

public class EButton extends EComponent {

    private JButton button;

    public EButton(@NotNull EPage page, @NotNull String displayText, @NotNull MouseAdapter event) {
        super(page);
        button = new JButton(displayText);
        this.add(button);
        // this.setBorder(BorderFactory.createLineBorder(Color.black));
        button.addMouseListener(event);
    }

    public void setPadding(int x, int y) {
        button.setBorder(BorderFactory.createEmptyBorder(y, x, y, x));
    }

}
