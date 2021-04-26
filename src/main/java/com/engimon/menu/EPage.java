package com.engimon.menu;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public abstract class EPage extends JPanel {

    public EPage() {
        super();
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        add(Box.createVerticalGlue());
    }

    public abstract void update();

}
