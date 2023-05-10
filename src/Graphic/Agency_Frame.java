package Graphic;

import Vehicle.Car_Agency;
import Vehicle.Vehicle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Agency_Frame extends JFrame  {

    JLabel display;
    ImageIcon imageIcon;


    public Agency_Frame() throws IOException {
        this.setVisible(true);
        this.setSize(1200, 1200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Agency");
        this.setLayout((new GridLayout()));



        for (int i = 0; i < Car_Agency.get_vehicle().length; i++) {

            Vehicle vehicle = Car_Agency.get_vehicle()[i];
            BufferedImage image = ImageIO.read(vehicle.get_Photo());
            ImageIcon icon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(icon);
            JButton button=new JButton(icon);
            button.addActionListener(e->{
                Operations frame=new Operations();
                this.dispose();


            });
            this.add(button);


            imageLabel.setIcon(imageIcon);
            setVisible(true);

        }

    }
}




