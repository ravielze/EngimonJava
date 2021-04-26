package com.engimon.menu;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.engimon.common.ResourceReader;
import com.engimon.menu.beginning.BeginningPage;
import com.engimon.menu.breeding.BreedingChooser;
import com.engimon.menu.inventory.Inventory;
import com.engimon.menu.main.MainPage;
import com.engimon.menu.start.StartPage;
import com.engimon.menu.switch_engimon.SwitchEngimon;

public class EMenu extends JFrame {

    public static final StartPage START_PAGE = new StartPage();
    public static final BeginningPage BEGINNING_PAGE = new BeginningPage();
    public static final MainPage MAIN_PAGE = new MainPage();
    public static final BreedingChooser BREEDING_CHOOSER = new BreedingChooser();
    public static final Inventory INVENTORY = new Inventory();
    public static final SwitchEngimon SWITCH_ENGIMON = new SwitchEngimon();

    private static EMenu instance;

    public static EMenu getInstance() {
        if (instance == null) {
            instance = new EMenu();
        }
        return instance;
    }

    public EMenu() {
        setLayout(new GridLayout(1, 0));
        setSize(new Dimension(800, 900));
        // setResizable(false);
        setTitle("Engimon - Gotta Farm Them All");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changePage(START_PAGE);
        setIcon();
        setVisible(true);
    }

    private void setIcon() {
        ResourceReader rr = new ResourceReader("Images/Others/gamelogo.png");
        try {
            BufferedImage image = ImageIO.read(rr.getStream());
            setIconImage(image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void changePage(EPage p) {
        if (p != null) {
            setVisible(false);
            getContentPane().removeAll();
            p.update();
            p.revalidate();
            p.setFocusable(true);
            p.requestFocusInWindow();
            JScrollPane pane = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            // pane.setFocusable(true);
            // pane.requestFocusInWindow();
            getContentPane().add(pane);
            revalidate();
            setVisible(true);
        }
    }

}
