package com.engimon.menu.start;

import javax.swing.Box;

import com.engimon.menu.EPage;
import com.engimon.menu.component.EButton;

public class StartPage extends EPage {

    public StartPage() {
        super();
        update();
    }

    @Override
    public String getName() {
        return "start_page";
    }

    @Override
    public void update() {
        removeAll();
        add(Box.createVerticalGlue());
        EButton newGame = new NewGame();
        newGame.setFocusable(true);
        add(newGame);
        EButton loadGame = new LoadGame();
        loadGame.setFocusable(true);
        add(loadGame);
    }

}
