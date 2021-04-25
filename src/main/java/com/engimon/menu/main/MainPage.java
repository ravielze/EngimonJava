package com.engimon.menu.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import com.engimon.entity.Game;
import com.engimon.entity.Player;
import com.engimon.entity.enums.Direction;
import com.engimon.exception.CellException;
import com.engimon.map.Map;
import com.engimon.menu.EPage;
import com.engimon.menu.component.EButton;
import com.engimon.menu.component.ERow;
import com.engimon.menu.component.EText;

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
        // setFocusable(true);
        // requestFocusInWindow();
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                Player player = Game.getRunningGame().getPlayer();
                Direction d = Direction.NORTH;
                switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    d = Direction.NORTH;
                    break;
                case KeyEvent.VK_A:
                    d = Direction.WEST;
                    break;
                case KeyEvent.VK_S:
                    d = Direction.SOUTH;
                    break;
                case KeyEvent.VK_D:
                    d = Direction.EAST;
                    break;
                default:
                    return;
                }
                try {
                    player.move(d);
                    update();
                    return;
                } catch (CellException er) {
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
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
        revalidate();
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }
}
