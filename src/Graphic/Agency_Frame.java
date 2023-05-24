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

/**
 * This class represents the main frame of the Car Agency program.
 * It extends the JFrame class and implements the ActionListener interface.
 * It displays the available vehicles in the car agency and allows the user to perform various operations on them.
 */
public class Agency_Frame extends JFrame implements ActionListener {

    JLabel display;
    private static Dialog d;
    ImageIcon imageIcon, icon;
    private Vehicle[] Temp_carAgency;
    int finalI;
    private Car_Agency carAgency;
    private int move;
    private JButton test_drive, buying_car, Flag_change, Reset, Exit;

    /**
     * Constructor for the Agency_Frame class.
     * It takes an array of vehicles and a move as parameters.
     * It sets the window properties and displays the available vehicles as buttons with their photos and tooltips.
     * @param vehicles The array of vehicles to be displayed.
     * @param move The move to be performed.
     */

    public Agency_Frame(Vehicle[] vehicles, int move) {
        this.carAgency = carAgency;
        this.move = move;

        // Set window properties
        this.setVisible(true);
        this.setSize(1200, 1000);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Agency");
        this.setLayout(new GridLayout());

        // Copy the vehicles array to the Temp_carAgency array
        Temp_carAgency = new Vehicle[Car_Agency.get_vehicle().length];
        for (int i = 0; i < Car_Agency.get_vehicle().length; i++) {
            Temp_carAgency[i] = Car_Agency.get_vehicle()[i];
        }
        // Display the vehicles as buttons with their photos and tooltips
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
        }
    }

    /**
     * This method is called when a button is clicked.
     * It gets the index of the clicked button, retrieves the corresponding vehicle and displays the operations frame.
     * @param e The ActionEvent object representing the button click event.
     */

    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();
        int index = Integer.parseInt(clickedButton.getActionCommand());
        Vehicle[] vehicles = Car_Agency.get_vehicle();
        Operations temp = new Operations(index, vehicles);
        temp.setVisible(true);


    }
}





















