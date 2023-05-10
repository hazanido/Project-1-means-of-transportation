package Graphic;

import Vehicle.Car_Agency;
import Vehicle.Vehicle;
import Vehicle.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Agency_Frame extends JFrame  {

    JLabel display;
    ImageIcon imageIcon;


    public Agency_Frame() throws IOException {
        this.setVisible(true);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Agency");


        JPanel carPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        for (int i = 0; i <= Car_Agency.get_vehicle().length; i++) {
            Vehicle vehicle = Car_Agency.get_vehicle()[i];
            BufferedImage image = ImageIO.read(vehicle.get_Photo());
            ImageIcon icon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(icon);
            carPanel.add(imageLabel);
            add(carPanel, BorderLayout.CENTER);
            setVisible(true);


            }
        /**,,

            imageIcon = new ImageIcon(getClass().getResource(agency.get_vehicle()[i].getImagePath()));
            display = new JLabel(imageIcon);
            display.setBounds(500, 100, imageIcon.getIconWidth(), imageIcon.getIconHeight());
            this.add(display);
            JButton button = new JButton(imageIcon);
            carPanel.add(button);

        }
         **/



    }
}




