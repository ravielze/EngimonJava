package com.engimon.menu.breeding;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import com.engimon.entity.engimon.Engimon;
import com.engimon.menu.EPage;
import com.engimon.menu.component.EButtonFactory;
import com.engimon.menu.component.EColumn;
import com.engimon.menu.component.EImage;
import com.engimon.menu.component.ERow;

public class Breeding extends EPage {
    private Engimon firstEngimon;
    private Engimon secondEngimon;
    private JTextArea engimonNameEditArea = new JTextArea("Child name");
    public Breeding(Engimon firstEngimon, Engimon secondEngimon) {
        this.firstEngimon = firstEngimon;
        this.secondEngimon = secondEngimon;

        update();
    }

    @Override
    public void update() {
        removeAll();
        add(Box.createRigidArea(new Dimension(0,20)));
        ERow titleRow = new ERow();
        JLabel title = new JLabel("BREEDING");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        titleRow.add(title);
        add(titleRow);


        ERow firstParentRow = new ERow();
        // TODO : Add first parent image before breeding stats
        firstParentRow.add(new EImage(firstEngimon.getIcon(), 100, 100));
        firstParentRow.add(new BreedingStats(firstEngimon));
        add(firstParentRow);

        EImage love = new EImage("Images/Others/Icon/heart_icon (for breeding)-min.png", 200, 130);
        add(love);

        ERow secondParentRow = new ERow();
        secondParentRow.add(new BreedingStats(secondEngimon));
        secondParentRow.add(new EImage(secondEngimon.getIcon(), 100, 100));

        // TODO : Add second parent image after breeding stats
        add(secondParentRow);

        ERow resultRowContainer = new ERow();
        ERow resultRow = new ERow();
        resultRow.setPreferredSize(new Dimension(400,100));
        resultRow.setBorder(BorderFactory.createLineBorder(Color.decode("#ff4278"), 20));
        resultRow.setBackground(Color.decode("#ff4278"));
        resultRowContainer.add(resultRow);
        // TODO : add child image
        // resultRow.add(...image)
        JPanel resultColumn = new JPanel(new GridLayout(0,1));
        resultColumn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        engimonNameEditArea.setFont(new Font("Arial", Font.PLAIN, 20));
        resultColumn.add(engimonNameEditArea);
        resultRow.add(Box.createRigidArea(new Dimension(0, 10)));
        resultColumn.add(new JLabel(firstEngimon.toString()));
        resultRow.add(resultColumn);

        add(resultRowContainer);

        add(EButtonFactory.CreateDefaultFontButton("Breed", Color.decode("#ff82a6"), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Change name and move to main page here
                String engimonName = engimonNameEditArea.getText();
            }
        }));
        

    }
}
