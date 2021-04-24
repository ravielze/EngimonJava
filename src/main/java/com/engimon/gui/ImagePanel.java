package com.engimon.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ImagePanel extends JPanel{

    private JLabel label;
    private BufferedImage image;
    private final String imageBasePath = "../Engi Images/";


    public ImagePanel(String imagePath) {
        String userDirectory = System.getProperty("user.dir");
        System.out.println(userDirectory);
       try { 
           
           image = ImageIO.read(new File(imageBasePath + imagePath));
           label = new JLabel(new ImageIcon(image));
           this.add(label);
       } catch (IOException ex) {
           System.out.println(imageBasePath + imagePath);
            // handle exception...
       }
    }

    // @Override
    // protected void paintComponent(Graphics g) {
    //     super.paintComponent(g);
    //     g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    // }

    @Override
    public void setPreferredSize(Dimension dim) {
        // TODO Auto-generated method stub
        super.setPreferredSize(dim);
        Image sizedImage = this.image.getScaledInstance((int) dim.getWidth(),(int) dim.getHeight(), Image.SCALE_REPLICATE);
        // this.remove(label);
        // label = new JLabel(new ImageIcon(sizedImage));
        // this.add(label);
    }

}