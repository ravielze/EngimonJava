package com.engimon.menu.component;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

public class EStackedImage extends JLayeredPane{
  public EStackedImage (ArrayList<EImage> images, int width, int height) {
    setPreferredSize(new Dimension(width, height));
    for (int i = 0; i < images.size(); i++) {
      images.get(i).setBounds(0,0,width, height);
      add(images.get(i), i);
    }
  }
}
