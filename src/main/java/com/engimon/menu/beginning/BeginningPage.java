package com.engimon.menu.beginning;

import java.awt.FlowLayout;
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
        add(text);
        List<EngimonPicker> buttons = new ArrayList<EngimonPicker>(6);
        GameConfig.getStarterEngimon().forEach(x -> {
            EngimonPicker ep = new EngimonPicker(x);
            ep.setPadding(30, 20);
            buttons.add(ep);
        });
        add(new ERow(new FlowLayout(FlowLayout.CENTER), new FlowLayout(FlowLayout.CENTER, 20, 40), 3, buttons));
    }

}
