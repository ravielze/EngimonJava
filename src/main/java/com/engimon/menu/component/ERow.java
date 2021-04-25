package com.engimon.menu.component;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.util.List;

import com.engimon.menu.EComponent;

public class ERow extends EComponent {

    public ERow(FlowLayout layout, FlowLayout rowLayout, int itemsPerRow, List<? extends EComponent> components) {
        setLayout(layout);
        int item = 0;
        JPanel row = null;
        for (EComponent ec : components) {
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
