package com.engimon.menu.help;

import java.awt.Font;

import javax.swing.JLabel;

import com.engimon.menu.EPage;
import com.engimon.menu.component.EBack;
import com.engimon.menu.component.ETitle;


public class Help extends EPage {

    @Override
    public void update() {
        // TODO Auto-generated method stub
        add(new ETitle("Help"));
        String html = "w - move 1 step north" + "<br />";
        html += "a - move 1 step west" + "<br />";
        html += "s - move 1 step south" + "<br />";
        html += "d - move 1 step east" + "<br />";
        html += "inventory – open inventory" + "<br />";
        html += "switch – switch active engimon" + "<br />";
        html += "interact – interact with active engimon" + "<br />";
        html += "breeding – breed engimon" + "<br />";
        html += "save – save game progress" + "<br />";
        html += "switch – switch active engimon" + "<br />";
        html += "(When encountering wild engimon): 1,2 or 3 - wild engimon selection to battle" + "<br />";

        JLabel label = new JLabel("<html>" + html + "</html>");
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        add(label);
        add(new EBack());
    }
    
}
