package com.engimon.menu.component;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;

import com.engimon.menu.EComponent;

public class EColumn extends JPanel implements EComponent {

    public EColumn() {
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        // setLayout(new GridLayout(0, 1));
        setLayout(boxLayout);
    }

    @Override
    public Component add(Component comp) {
        ERow row = new ERow();
        row.add(comp);
        return super.add(row);
    }

    public void justifyFlexStart() {
        for (Component c : getComponents()) {
            if (c instanceof ERow) {
                ((ERow) c).justifyFlexStart();
            }
        }
    }

    public void justifyFlexEnd() {
        for (Component c : getComponents()) {
            if (c instanceof ERow) {
                ((ERow) c).justifyFlexEnd();
            }
        }
    }
}
