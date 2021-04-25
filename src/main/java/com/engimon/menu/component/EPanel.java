package com.engimon.menu.component;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class EPanel extends JPanel {

    /**
     * The value of the alignment argument must be one of {@code FlowLayout.LEFT},
     * {@code FlowLayout.RIGHT}, {@code FlowLayout.CENTER},
     * {@code FlowLayout.LEADING}, or {@code FlowLayout.TRAILING}.
     * 
     * @param align the alignment value
     */
    public EPanel(int align) {
        super();
        setLayout(new FlowLayout(align));
    }

}
