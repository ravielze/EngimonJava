package com.engimon.gui;


import javax.swing.*;
import java.awt.*;


public class GUI implements GUIMediator {
    private JFrame frame;
    private StartPage startPage;
    private Map map;

    public void chooseEngimon(String a) {
        // Pick engimon
        // Ganti frame
        System.out.println(a);
        
        frame.getContentPane().removeAll();
        frame.getContentPane().add(map);
        frame.setTitle("Map");
        frame.revalidate();
    }
    public GUI() {
        frame = new JFrame();
        startPage = new StartPage();
        map = new Map();
        startPage.setMediator(this);
        map.setMediator(this);



        frame.setLayout(new GridLayout(1,0));
        frame.setSize(200,300);
        frame.setTitle("Start Page");
        // Initialize other here;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(startPage);
        frame.setVisible(true);

    }

}
