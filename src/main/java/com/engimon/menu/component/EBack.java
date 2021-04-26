package com.engimon.menu.component;

import java.awt.event.MouseAdapter;
import java.awt.Color;

import javax.swing.JPanel;

import com.engimon.menu.EMenu;

import java.awt.event.MouseEvent;
public class EBack extends JPanel {

    public EBack() {
        
        add(EButtonFactory.CreateDefaultFontButton("Back", Color.decode("#fcff5e"), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EMenu.getInstance().changePage(EMenu.MAIN_PAGE);
            }
        }));
    }
    
}
