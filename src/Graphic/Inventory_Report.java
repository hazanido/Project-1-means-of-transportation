package Graphic;

import Vehicle.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Inventory_Report extends JFrame {
    private Vehicle[] Temp_carAgency;

    public Inventory_Report() {
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
        Temp_carAgency = new Vehicle[Car_Agency.get_vehicle().length];
        for (int i = 0; i < Car_Agency.get_vehicle().length; i++) {
            Temp_carAgency[i] = Car_Agency.get_vehicle()[i];
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
            imageLabel.setToolTipText(Car_Agency.get_vehicle()[i].toString());

            this.add(imageLabel);


            Thread updateThread = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        //updateInventoryReport();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            });
            updateThread.start();
        }
    }
}










