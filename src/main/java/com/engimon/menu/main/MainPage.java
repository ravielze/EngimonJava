package com.engimon.menu.main;

import com.engimon.entity.Game;
import com.engimon.entity.enums.Direction;
import com.engimon.exception.CellException;
import com.engimon.map.Map;
import com.engimon.menu.EPage;
import com.engimon.menu.component.EButton;
import com.engimon.menu.component.ERow;
import com.engimon.menu.component.EText;
import com.engimon.sound.BackgroundSound;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class MainPage extends EPage {

    private Map map = Map.getInstance();
    private EButton help = new EButton(this, "Help", new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("HELP CLICKED");
            BackgroundSound.getInstance().play("beginning_sound");
        }
    });

    private EButton inv = new EButton(this, "Inventory", new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("INVENTORY CLICKED");
            BackgroundSound.getInstance().play("battle_sound");
        }
    });

    private EText message = new EText(this, "");

    private List<EButton> menuList = new ArrayList<EButton>();

    public MainPage() {
        super();
        update();
        menuList.add(help);
        menuList.add(inv);
        // setFocusable(true);
        // requestFocusInWindow();
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                try {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_W:
                            Game.getPlayer().move(Direction.NORTH);
                            update();

                            break;
                        case KeyEvent.VK_A:
                            Game.getPlayer().move(Direction.WEST);
                            update();

                            break;
                        case KeyEvent.VK_S:
                            Game.getPlayer().move(Direction.SOUTH);
                            update();

                            break;
                        case KeyEvent.VK_D:
                            Game.getPlayer().move(Direction.EAST);
                            update();

                            break;
                    }
                } catch (CellException er) {
                    
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
            }

        });
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
