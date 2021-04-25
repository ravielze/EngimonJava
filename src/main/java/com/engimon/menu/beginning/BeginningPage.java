package com.engimon.menu.beginning;

import java.util.ArrayList;
import java.util.List;

import com.engimon.entity.GameConfig;
import com.engimon.menu.EPage;
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

        EText text = new EText(this, bacotan);
        ERow pickerRow1 = new ERow();
        ERow pickerRow2 = new ERow();

        List<EngimonPicker> buttons = new ArrayList<EngimonPicker>(6);
        buttons.add(new EngimonPicker(GameConfig.getEngimon()));
        buttons.add(new EngimonPicker("Engimon2"));
        buttons.add(new EngimonPicker("Engimon3"));
        buttons.add(new EngimonPicker("Engimon4"));
        buttons.add(new EngimonPicker("Engimon5"));
        buttons.add(new EngimonPicker("Engimon6"));
        buttons.subList(0, 3).forEach(x -> pickerRow1.add(x));
        buttons.subList(3, 6).forEach(x -> pickerRow2.add(x));
        add(text);
        add(pickerRow1);
        add(pickerRow2);
        // GameConfig.getStarterEngimon().forEach(x -> {
        //     EngimonPicker ep = new EngimonPicker(x);
        //     ep.setPadding(30, 20);
        //     buttons.add(ep);
        // });
        // int perRow = 3;
        // int cur = 0;
        // for (String l : array) {
        //     if (cur == perRow) {
        //         picker.add(new ArrayList<EngimonPicker>(buttons));
        //         buttons = new ArrayList<EngimonPicker>(6);
        //         cur = 0;
        //         add(picker.);
        //         picker.removeAll();
        //     }
        //     EngimonPicker ep = new EngimonPicker(l);
        //     ep.setPadding(30, 20);
        //     buttons.add(ep);
        //     cur += 1;
        // }
        // if (cur == perRow) {
        //     picker.add(new ArrayList<EngimonPicker>(buttons));
        // }

        // picker.add(buttons);
        // picker.justifyFlexStart();

        
        // add(new ERow(new FlowLayout(FlowLayout.CENTER), new FlowLayout(FlowLayout.CENTER, 20, 40), 3, buttons));
    }

}
