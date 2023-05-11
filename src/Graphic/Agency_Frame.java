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
import java.io.IOException;
import java.util.concurrent.Callable;


public class Agency_Frame extends JFrame implements ActionListener {

    JLabel display;
    private static Dialog d;
    ImageIcon imageIcon, icon;
    private Vehicle[] Temp_carAgency;
    int finalI;


    public Agency_Frame() {

        this.setVisible(true);
        this.setSize(1200, 1200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Agency");
        this.setLayout((new GridLayout()));
        Temp_carAgency = new Vehicle[Car_Agency.get_vehicle().length];
        for (int i = 0; i < Car_Agency.get_vehicle().length; i++) {
            Temp_carAgency[i] = Car_Agency.get_vehicle()[i];
        }
        for (int i = 0; i < Temp_carAgency.length; i++) {
            finalI = i;
            Vehicle vehicle = Temp_carAgency[i];
            BufferedImage image = null;
            try {
                image = ImageIO.read(vehicle.get_Photo());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            icon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(icon);
            JButton button = new JButton(icon);
            button.setToolTipText(Car_Agency.get_vehicle()[i].toString());
            button.addActionListener(this);
            this.add(button);


            ActionListener f = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand().equals(icon)) {
                        Operations temp = new Operations();
                    }
                    if (e.getActionCommand().equals("Test_drive")) {
                        Test_drive frame = new Test_drive(finalI, Temp_carAgency);


                    }
                }
            };
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(icon)) {
            Operations temp = new Operations();
        }
        if (e.getActionCommand().equals("Test_drive")) {
            Test_drive frame = new Test_drive(finalI, Temp_carAgency);


        }
    }
}











