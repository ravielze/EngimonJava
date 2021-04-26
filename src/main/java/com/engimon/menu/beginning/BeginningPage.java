package com.engimon.menu.beginning;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;

import com.engimon.entity.Cheat;
import com.engimon.menu.EPage;
import com.engimon.menu.component.EImage;
import com.engimon.menu.component.ERow;
import com.engimon.menu.component.EText;

public class BeginningPage extends EPage {
    private final String bacotan = "Bacotan lalalalaal";

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

        EText text = new EText(bacotan);
        ERow textRowContainer = new ERow();
        ERow textRow = new ERow();
        textRowContainer.add(textRow);
        textRow.add(text);
        textRow.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.decode("#a3a3a3"), Color.decode("#616161")));
        ERow pickerRow1 = new ERow();
        ERow pickerRow2 = new ERow();

        List<EngimonPicker> buttons = new ArrayList<EngimonPicker>(6);
        buttons.add(new EngimonPicker(Cheat.getEngimon()));
        buttons.add(new EngimonPicker(Cheat.getSecondEngimon()));
        buttons.add(new EngimonPicker(Cheat.getThirdEngimon()));
        buttons.add(new EngimonPicker("Engimon4"));
        buttons.add(new EngimonPicker("Engimon5"));
        buttons.add(new EngimonPicker("Engimon6"));
        buttons.subList(0, 3).forEach(x -> pickerRow1.add(x));
        buttons.subList(3, 6).forEach(x -> pickerRow2.add(x));
        add(new EImage("Images/Others/prof.png", 100, 200));
        add(textRowContainer);
        add(pickerRow1);
        add(pickerRow2);
    }
}
