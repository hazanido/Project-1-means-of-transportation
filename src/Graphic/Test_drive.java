package Graphic;

import Decorator.carStatus;
import Vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The Test_drive class creates a JFrame window for testing a specific vehicle's movement.
 * It allows the user to enter the distance traveled on a test drive and updates the
 * vehicle's total distance traveled accordingly.
 */
public class Test_drive extends JFrame implements ActionListener{
    private JButton Back;
    private JTextField move;
    private Vehicle vehicle;
    private int index;
    private float generalDistance=0;


    /**
     * Constructs a new Test_drive window for a specific vehicle.
     *
     * @param i        The index of the vehicle in the array of vehicles.
     * @param vehicles The array of vehicles in the car agency.
     */
    public Test_drive(int i, List<Vehicle> vehicles) {
        index = i;
        // Set window properties
        this.vehicle = vehicles.get(i);
        this.setVisible(true);
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.index = i;
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Test_drive");

        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(15, 20, 150, 20);
        this.add(lebal1);
        move = new JTextField();
        move.setBounds(15, 50, 150, 20);
        move.setToolTipText("Please enter the distance you traveled on a test drive");


        Back = new JButton();
        Back.setBounds(20, 100, 150, 30);
        Back.setText("Back to the agency");
        this.add(Back);
        this.add(move);
        Back.addActionListener(this);
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back to the agency")) {
            try {
                //Vehicle Vehicle1 =Threads_class.get_Instance().get_Vehicles().get(i);
                int distance = Integer.parseInt(move.getText());
                int temp = vehicle.get_move();
                vehicle.set_Move(temp + distance);
                generalDistance += distance;

                main_window.updateTotalDistance(generalDistance);

                Agency_Frame temp1 = new Agency_Frame(Threads_class.get_Instance().get_Vehicles());

                Threads_class.get_Instance().Update_distance(index, temp + distance, 200);
                carStatus.changeStatus("In stock");

                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");


            }
        }
    }

}









