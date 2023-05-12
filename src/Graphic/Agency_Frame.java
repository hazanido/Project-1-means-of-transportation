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
    private Car_Agency carAgency;
    private int move;
    private JButton test_drive, buying_car, Flag_change, Reset, Exit;


    public Agency_Frame(Vehicle[] vehicles, int move) {
        this.carAgency = carAgency;
        this.move = move;

        this.setVisible(true);
        this.setSize(1200, 1000);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Agency");
        this.setLayout((new GridLayout(2,2)));
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
            ImageIcon icon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(icon);
            JButton button = new JButton(icon);
            button.setToolTipText(Car_Agency.get_vehicle()[i].toString());
            button.setActionCommand(String.valueOf(i));
            button.addActionListener(this);
            this.add(button);
        }}


    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();
        int index = Integer.parseInt(clickedButton.getActionCommand());
        Vehicle[] vehicles = Car_Agency.get_vehicle();
        Operations temp = new Operations(index, vehicles);
        temp.setVisible(true);
        this.dispose();
    }
}





















