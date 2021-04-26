package com.engimon.menu.beginning;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import com.engimon.entity.GameConfig;
import com.engimon.entity.engimon.Engimon;
import com.engimon.menu.EPage;
import com.engimon.menu.component.EImage;
import com.engimon.menu.component.ERow;

public class BeginningPage extends EPage {
    private final String bacotan = "Hello young unemployed person! I'm professor Cemara, here to give you a chance to kill time. <br/> Please choose an engimon below to start your journey!";

    public BeginningPage() {
        super();
        update();
    }

    @Override
    public String getName() {
        return "game_beginning";
    }

    @Override
    public void update() {
        removeAll();

        JLabel text = new JLabel("<html>" + bacotan + "</html>");
        text.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        text.setFont(new Font("Arial", Font.PLAIN, 14));
        ERow textRowContainer = new ERow();
        ERow textRow = new ERow();
        textRowContainer.add(textRow);
        textRow.add(text);
        textRow.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.decode("#a3a3a3"), Color.decode("#616161")));
        add(new EImage("Images/Others/prof.png", 100, 200));
        add(textRowContainer);
        List<ERow> rowList = new ArrayList<ERow>();
        int engiPerRow = 3;
        int curRow = -1;
        int item = 0;
        List<Engimon> starters = GameConfig.getStarterEngimon();
        for(Engimon en : starters) {
            if (item == 0) {
                curRow += 1;
                rowList.add(new ERow());
            }
            rowList.get(curRow).add(new EngimonPicker(en));
            item += 1;
            item = item % engiPerRow;
        }
        for (ERow row : rowList) {
            add(row);
        }
    }
}
