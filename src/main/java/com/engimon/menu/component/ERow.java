package com.engimon.menu.component;

import java.awt.Component;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JPanel;

import com.engimon.menu.EComponent;

public class ERow extends JPanel implements EComponent {
    public ERow() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }

    public void justifyFlexStart() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public void justifyFlexEnd() {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    public void add(List<? extends Component> components) {
        components.forEach(component -> add(component));
    }

    public ERow(FlowLayout layout, FlowLayout rowLayout, int itemsPerRow, List<? extends Component> components) {
        setLayout(layout);
        int item = 0;
        JPanel row = null;
        for (Component ec : components) {
            if (item == 0) {
                item = itemsPerRow;
                if (row != null) {
                    add(row);
                }
                row = new JPanel();
                row.setLayout(rowLayout);
            }
            row.add(ec);
            item--;
        }
    }
}
