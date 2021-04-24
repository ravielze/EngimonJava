package com.engimon.gui;


import javax.swing.*;
import java.awt.*;


public class GUI implements GUIMediator {
    private JFrame frame;
    private StartPage startPage;

    public void chooseEngimon(String a) {
        // Pick engimon
        // Ganti frame
        System.out.println(a);
    }
    public GUI() {
        frame = new JFrame();
        startPage = new StartPage();
        startPage.setMediator(this);



        frame.setLayout(new GridLayout(1,0));
        frame.setSize(200,300);
        frame.setTitle("Start Page");
        // Initialize other here;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(startPage);
        frame.setVisible(true);
    }

}
