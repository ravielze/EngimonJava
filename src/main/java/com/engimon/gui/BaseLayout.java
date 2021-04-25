package com.engimon.gui;
import javax.swing.*;
public class BaseLayout extends JPanel {
    public BaseLayout() {
        super();
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
    }
}
