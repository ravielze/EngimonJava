package com.engimon.menu;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.engimon.menu.beginning.BeginningPage;
import com.engimon.menu.main.MainPage;
import com.engimon.menu.start.StartPage;

public class EMenu extends JFrame {

    public static final StartPage START_PAGE = new StartPage();
    public static final BeginningPage BEGINNING_PAGE = new BeginningPage();
    public static final MainPage MAIN_PAGE = new MainPage();

    private static EMenu instance;

    public static EMenu getInstance() {
        if (instance == null) {
            instance = new EMenu();
        }
        return instance;
    }

    public EMenu() {
        setLayout(new GridLayout(1, 0));
        setSize(200, 300);
        setTitle("Engimon - Gotta Farm Them All");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changePage(START_PAGE);
        // changePage(MAIN_PAGE);
        setVisible(true);
    }

    public void changePage(EPage p) {
        if (p != null) {
            getContentPane().removeAll();
            p.update();
            p.setFocusable(true);
            p.requestFocusInWindow();
            JScrollPane pane = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            // pane.setFocusable(true);
            // p.requestFocusInWindow();
            getContentPane().add(pane);
            revalidate();
        }
    }

}
