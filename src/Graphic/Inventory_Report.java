package Graphic;

import Vehicle.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Inventory_Report extends JFrame  implements ChangeListener{
    private Vehicle[] Temp_carAgency;

    public Inventory_Report() {
        Threads_class.get_Instance().addListener(this);
        // Set window properties
        this.setVisible(true);
        this.setSize(600, 600);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Current Inventory Report");
        this.setLayout(new GridLayout());


        // Copy the vehicles array to the Temp_carAgency array
        Temp_carAgency = new Vehicle[Threads_class.get_Instance().get_Vehicles().size()];
        for (int i = 0; i < Threads_class.get_Instance().get_Vehicles().size(); i++) {
            Temp_carAgency[i] = Threads_class.get_Instance().get_Vehicles().get(i);
        }

        for (int i = 0; i < Temp_carAgency.length; i++) {
            Vehicle vehicle = Temp_carAgency[i];
            BufferedImage image = null;
            try {
                image = ImageIO.read(vehicle.get_Photo());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ImageIcon icon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(icon);
            imageLabel.setToolTipText(Threads_class.get_Instance().get_Vehicles().get(i).toString());

            this.add(imageLabel);

        }
    }
    public void change_listener(){
        this.dispose();
        Inventory_Report frame=new Inventory_Report();



    }
}














