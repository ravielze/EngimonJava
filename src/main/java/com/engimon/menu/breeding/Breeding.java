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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.engimon.entity.Game;
import com.engimon.entity.engimon.Engimon;
import com.engimon.exception.EngimonStateException;
import com.engimon.menu.EPage;
import com.engimon.menu.component.EBack;
import com.engimon.menu.component.EButtonFactory;
import com.engimon.menu.component.EImage;
import com.engimon.menu.component.ERow;

public class Breeding extends EPage {
    private Engimon firstEngimon;
    private Engimon secondEngimon;
    private Engimon result;
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
        firstParentRow.add(new EImage(firstEngimon.getIcon(), 100, 100));
        firstParentRow.add(new BreedingStats(firstEngimon));
        add(firstParentRow);

        EImage love = new EImage("Images/Others/Icon/heart_icon (for breeding)-min.png", 200, 130);
        add(love);

        ERow secondParentRow = new ERow();
        secondParentRow.add(new BreedingStats(secondEngimon));
        secondParentRow.add(new EImage(secondEngimon.getIcon(), 100, 100));

        add(secondParentRow);

        ERow resultRowContainer = new ERow();
        ERow resultRow = new ERow();
        resultRow.setPreferredSize(new Dimension(400,100));
        resultRow.setBorder(BorderFactory.createLineBorder(Color.decode("#ff4278"), 16));
        resultRow.setBackground(Color.decode("#ff4278"));
        resultRowContainer.add(resultRow);

        try {
            result = firstEngimon.breed(secondEngimon);
            System.out.println(result.toString());
            JOptionPane.showMessageDialog(this, "Success");
        } catch (EngimonStateException er) {
            System.out.println(er.getStateError());
            JOptionPane.showMessageDialog(this, "Tdak bisa melakukan breeding karena level dibawah 4");
            
        }
        if (result != null) {
            resultRow.add(new EImage(result.getIcon(), 50, 50));
            resultRow.add(Box.createRigidArea(new Dimension(20, 0)));
            JPanel resultColumn = new JPanel(new GridLayout(0,1));
            resultColumn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            engimonNameEditArea.setFont(new Font("Arial", Font.PLAIN, 20));
            resultColumn.add(engimonNameEditArea);
            resultRow.add(Box.createRigidArea(new Dimension(0, 10)));
            resultColumn.add(new JLabel(result.toString()));
            resultRow.add(resultColumn);
        }


        add(resultRowContainer);

        add(EButtonFactory.CreateDefaultFontButton("Breed", Color.decode("#ff82a6"), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Change name and move to main page here
                String engimonName = engimonNameEditArea.getText();
                if (result != null) {
                    result.setName(engimonName);
                    Game.getRunningGame().getPlayer().addEngimon(result);
                }
                
            }
        }));
        add(new EBack());

    }
}
