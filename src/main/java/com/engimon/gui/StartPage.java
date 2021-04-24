package com.engimon.gui;

import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import java.awt.image.BufferedImage;
public class StartPage extends JPanel implements Screen {
    private GUIMediator mediator;
    private JPanel engimonPicker;
    private BufferedImage professorImage;
    @Override
    public void setMediator (GUIMediator m) {
        this.mediator = m;
    }

    @Override 
    public String getName() {
        return "Start Page";
    }

    public StartPage() {
        super();
        prepareGui();
    }

    private void prepareGui() {
        System.out.println("Sampe sini");

        JButton button1 = new JButton("Hello world"); // Ganti ke gambar professor
        JButton button2 = new JButton("Hello world2"); // Ganti ke bacotan awal

        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);

        JPanel row1 = new JPanel();
        row1.setLayout(new FlowLayout(FlowLayout.CENTER));
        row1.add(button1);

        
        JPanel row2 = new JPanel();
        row2.setLayout(new FlowLayout(FlowLayout.CENTER));
        row2.add(button2);

        this.setLayout(boxLayout);
        this.add(row1);
        this.add(row2);
        preparePicker();
    }
    private void addRow(String[] labels) {
        JPanel row = new JPanel();
        row.setLayout(new FlowLayout(FlowLayout.CENTER));

        for (String label : labels) {
            JLabel engimon = new JLabel(label);
            engimon.addMouseListener(new MouseAdapter()  
            {  
                public void mouseClicked(MouseEvent e)  
                {  
                    mediator.chooseEngimon(label);
                }  
            });
            row.add(engimon);
        }
        this.engimonPicker.add(row);
    }
    private void preparePicker() {
        this.engimonPicker = new JPanel();

        BoxLayout boxLayout = new BoxLayout(this.engimonPicker, BoxLayout.Y_AXIS);
        this.engimonPicker.setLayout(boxLayout);

        String[] row1 = {"Engimon 1", "Engimon 2", "Engimon 3"};
        String[] row2 = {"Engimon 4", "Engimon 5"};

        addRow(row1);
        addRow(row2);
        
        this.add(engimonPicker);
    }
}