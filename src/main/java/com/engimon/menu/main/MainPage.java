package com.engimon.menu.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;

import com.engimon.entity.Cheat;
import com.engimon.entity.Game;
import com.engimon.entity.Player;
import com.engimon.entity.engimon.WildEngimon;
import com.engimon.entity.enums.Direction;
import com.engimon.exception.CellException;
import com.engimon.map.Map;
import com.engimon.map.biome.Cell;
import com.engimon.menu.EMenu;
import com.engimon.menu.EPage;
import com.engimon.menu.component.EButton;
import com.engimon.menu.component.EButtonFactory;
import com.engimon.menu.component.EImage;
import com.engimon.menu.component.ERow;
import com.engimon.menu.component.EText;

public class MainPage extends EPage {

    private EButton inv = EButtonFactory.CreateDefaultFontButton("Inventory", Color.decode("#ffc847"),
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    EMenu.getInstance().changePage(EMenu.INVENTORY);
                }
            });

    private EButton switchb = EButtonFactory.CreateDefaultFontButton("Switch", Color.decode("#ffc847"),
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    EMenu.getInstance().changePage(EMenu.SWITCH_ENGIMON);
                }
            });

    private EButton interact = EButtonFactory.CreateDefaultFontButton("Interact", Color.decode("#ffc847"),
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setMessage(Game.getRunningGame().getPlayer().getActiveEngimon().interact());
                }
            });

    private EButton breed = EButtonFactory.CreateDefaultFontButton("Breed", Color.decode("#ffc847"),
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    EMenu.getInstance().changePage(EMenu.BREEDING_CHOOSER);
                }
            });

    private EButton save = EButtonFactory.CreateDefaultFontButton("Save", Color.decode("#ffc847"), new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Game.save(Game.getRunningGame().getPlayer());
        }
    });

    private EButton help = EButtonFactory.CreateDefaultFontButton("Help", Color.decode("#ffc847"), new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            EMenu.getInstance().changePage(EMenu.HELP);
        }
    });

    private EButton cheat = EButtonFactory.CreateDefaultFontButton("Cheat", Color.decode("#ffc847"), new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Cheat.IncreaseExpBy(2000);
        }
    });

    private EText message = new EText("");

    public MainPage() {
        super();
        message.setFont(new Font("Arial", Font.PLAIN, 25));
        update();

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                Player player = Game.getRunningGame().getPlayer();
                Direction d = Direction.NORTH;
                switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    d = Direction.SOUTH;
                    break;
                case KeyEvent.VK_A:
                    d = Direction.EAST;
                    break;
                case KeyEvent.VK_S:
                    d = Direction.NORTH;
                    break;
                case KeyEvent.VK_D:
                    d = Direction.WEST;
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
    public void addTopMenu() {
        ERow menuRow = new ERow();
        menuRow.justifyFlexStart();

        menuRow.add(new EImage("Images/Others/Icon/inventory_icon-min.png", 24, 24));
        menuRow.add(inv);

        menuRow.add(new EImage("Images/Others/Icon/switch_icon-min.png", 24, 24));
        menuRow.add(switchb);

        menuRow.add(new EImage("Images/Others/Icon/interact_icon-min.png", 24, 24));
        menuRow.add(interact);

        menuRow.add(new EImage("Images/Others/Icon/breed_icon-min.png", 24, 24));
        menuRow.add(breed);

        menuRow.add(new EImage("Images/Others/Icon/save_icon-min.png", 24, 24));
        menuRow.add(save);

        menuRow.add(new EImage("Images/Others/Icon/help_icon-min.png", 24, 24));
        menuRow.add(help);
        
        menuRow.add(cheat);
        add(menuRow);
    }
    @Override
    public String getName() {
        return "main_page";
    }

    @Override
    public synchronized void update() {
        Map map = Map.getInstance();
        removeAll();
        addTopMenu();
        List<WildEngimon> wildEngimons = new ArrayList<WildEngimon>();
        if (Game.getRunningGame() != null) {
            Cell currentPos = Game.getRunningGame().getPlayer().getPosition();
            wildEngimons = Map.getSurroundingEngimon(currentPos.getX(), currentPos.getY());
        }
        ERow gridRow = new ERow();
        gridRow.add(new MapGrid(map));
        gridRow.add(new BattleList(wildEngimons));

        ERow messageRow = new ERow();
        messageRow.add(message);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(gridRow);
        add(messageRow);
        revalidate();
    }

    public void setMessage(String message) {
        this.message.setText(message);
        update();
    }
}
