package com.engimon.menu;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;

public abstract class EPage extends JPanel {

    public EPage() {
        super();
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        // setLayout(new GridLayout(0, 1));
        setLayout(boxLayout);
        // add(Box.createVerticalGlue());
    }

    public abstract void update();

}
