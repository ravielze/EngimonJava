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

        // JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        // frame.add(scrollPane);
        
        frame.add(startPage);
        frame.setVisible(true);

    }

}
