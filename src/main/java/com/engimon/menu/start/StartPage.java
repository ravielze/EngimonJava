package com.engimon.menu.start;

import java.awt.FlowLayout;

import com.engimon.menu.EPage;
import com.engimon.menu.component.EButton;
import com.engimon.menu.component.EImage;
import com.engimon.menu.component.EPanel;

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
        EImage title = new EImage("Images/Others/gametitle.png", 400, 200);
        add(title);
        EImage logo = new EImage("Images/Others/gamelogo.png", 250, 250);
        add(logo);
        EButton newGame = new NewGame();
        EButton loadGame = new LoadGame();
        EPanel button = new EPanel(FlowLayout.CENTER);
        button.add(newGame);
        EPanel button2 = new EPanel(FlowLayout.CENTER);
        button2.add(loadGame);
        add(button);
        add(button2);
    }

}
