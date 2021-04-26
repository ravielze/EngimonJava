package com.engimon.menu.beginning;

import java.util.ArrayList;
import java.util.List;

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
        add(new EImage("Images/Others/prof.png", 50, 100));
        add(text);
        add(pickerRow1);
        add(pickerRow2);
    }
}
