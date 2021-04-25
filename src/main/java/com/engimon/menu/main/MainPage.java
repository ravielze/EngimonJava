package com.engimon.menu.main;

import com.engimon.map.Map;
import com.engimon.menu.EPage;
import com.engimon.menu.component.EButton;
import com.engimon.menu.component.ERow;
import com.engimon.menu.component.EText;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class MainPage extends EPage {

    private Map map = Map.getInstance();
    private EButton help = new EButton(this, "Help", new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("HELP CLICKED");
        }
    });

    private EButton inv = new EButton(this, "Inventory", new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("INVENTORY CLICKED");
        }
    });

    private EText message = new EText(this, "");

    private List<EButton> menuList = new ArrayList<EButton>();

    public MainPage() {
        super();
        update();
        menuList.add(help);
        menuList.add(inv);
        System.out.println(map.getSize());
    }

    @Override
    public String getName() {
        return "main_page";
    }

    @Override
    public void update() {
        removeAll();
        ERow menuRow = new ERow();
        menuRow.justifyFlexStart();
        menuRow.add(menuList);

        ERow gridRow = new ERow();
        gridRow.add(new MapGrid(map));
        
        ERow messageRow = new ERow();
        message.setText("Hello world");
        messageRow.add(message);

        add(menuRow);
        add(gridRow);
        add(messageRow);
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }
}
