package Graphic;

import javax.swing.*;
import java.awt.*;
import Vehicle.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

/**
 * This class represents a GUI window for performing operations on a Vehicle object.
 * The class extends JFrame and implements ActionListener interface.
 * It contains buttons for test driving a vehicle, buying a vehicle, changing flag and resetting all the vehicles data.
 */


public class Operations extends JFrame implements ActionListener {
    private Vehicle vehicle;
    private int i;
    private JButton test_drive, buying_car, Flag_change, Reset, Exit;
    private Vehicle[] vehicles;

    /**
     * Constructor for the Operations class. Initializes instance variables and sets up the GUI window.
     *  @param i The index of the vehicle in the array of vehicles passed to the constructor.
     *  @param vehicles An array of Vehicle objects.
     */

    public Operations(int i, Vehicle[] vehicles) {
        this.i = i;
        this.vehicles = vehicles;

        // Set window properties
        this.setVisible(true);
        this.setSize(400, 320);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("test_drive or buying car");


        test_drive = new JButton("Test drive");
        buying_car = new JButton("Buying car");
        Flag_change = new JButton("Flag change");
        Reset = new JButton("Reset All");
        Exit = new JButton("Exit");


        test_drive.setBounds(30, 40, 150, 60);
        test_drive.addActionListener(this);
        this.add(test_drive);

        buying_car.setBounds(200, 40, 150, 60);
        buying_car.addActionListener(this);
        this.add(buying_car);

        Flag_change.setBounds(110, 120, 150, 60);
        Flag_change.addActionListener(this);
        this.add(Flag_change);

        Reset.setBounds(15, 240, 100, 30);
        Reset.addActionListener(this);
        this.add(Reset);

        Exit.setBounds(260, 240, 100, 30);
        Exit.addActionListener(this);
        this.add(Exit);

    }
    /**
     * Action listener method for the buttons in the GUI window.
     * @param e An ActionEvent object.
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Test drive")) {
            Test_drive frame = new Test_drive(i, vehicles);
            this.dispose();
        }
        else if (e.getActionCommand().equals("Buying car")) {
            Buying_car frame = new Buying_car(i, vehicles);
            this.dispose();

        }
        else if(e.getActionCommand().equals("Flag change")){
            Flag_selection frame=new Flag_selection(i,vehicles);
            this.dispose();
        }
        else if(e.getActionCommand().equals("Reset All")){
            for (int i = 0; i < Car_Agency.get_vehicle().length; i++) {
                Car_Agency.get_vehicle()[i].set_Model_Name(null);
                Car_Agency.get_vehicle()[i].set_Move(0);
                Car_Agency.get_vehicle()[i].set_Distance(0);
                Car_Agency.get_vehicle()[i].set_Max_Passengers(0);
                Car_Agency.get_vehicle()[i].set_Max_Speed(0);
                Car_Agency.get_vehicle()[i].set_Max_Passengers(0);
                Car_Agency.get_vehicle()[i].set_Max_Speed(0);
                if(Car_Agency.get_vehicle()[i] instanceof Jeep){
                    ((Jeep) Car_Agency.get_vehicle()[i]).Average_fuel_consumption();
                    ((Jeep) Car_Agency.get_vehicle()[i]).Average_life_engine();
                    ((Jeep) Car_Agency.get_vehicle()[i]).set_Number_Wheels(0);
                    ((Jeep) Car_Agency.get_vehicle()[i]).license_type();
                    ((Jeep) Car_Agency.get_vehicle()[i]).set_Kind_Way(null);

                }
                else if(Car_Agency.get_vehicle()[i] instanceof Bicycle){
                    ((Bicycle) Car_Agency.get_vehicle()[i]).set_Number_Wheels(0);
                    ((Bicycle) Car_Agency.get_vehicle()[i]).set_Kind_Way(null);
                    ((Bicycle) Car_Agency.get_vehicle()[i]).Energy_score();
                    ((Bicycle) Car_Agency.get_vehicle()[i]).power_source(null);
                }
                else if(Car_Agency.get_vehicle()[i] instanceof Cruise_ship){
                    ((Cruise_ship) Car_Agency.get_vehicle()[i]).Average_life_engine();
                    ((Cruise_ship) Car_Agency.get_vehicle()[i]).Average_fuel_consumption();
                    ((Cruise_ship) Car_Agency.get_vehicle()[i]).set_target(null);
                    ((Cruise_ship) Car_Agency.get_vehicle()[i]).set_Because(false);
                    ((Cruise_ship) Car_Agency.get_vehicle()[i]).license_type();
                }
                else if(Car_Agency.get_vehicle()[i] instanceof Dawn_Rigoli){
                    ((Dawn_Rigoli) Car_Agency.get_vehicle()[i]).set_Type(null);
                    ((Dawn_Rigoli) Car_Agency.get_vehicle()[i]).power_source(null);
                    ((Dawn_Rigoli) Car_Agency.get_vehicle()[i]).Energy_score();
                }
                else if(Car_Agency.get_vehicle()[i] instanceof Frigate){
                    ((Frigate) Car_Agency.get_vehicle()[i]).set_Because(false);
                    ((Frigate) Car_Agency.get_vehicle()[i]).set_target(null);
                    ((Frigate) Car_Agency.get_vehicle()[i]).Average_fuel_consumption();
                    ((Frigate) Car_Agency.get_vehicle()[i]).Average_life_engine();
                }
                else if(Car_Agency.get_vehicle()[i] instanceof Game_Drone){
                    ((Game_Drone) Car_Agency.get_vehicle()[i]).power_source(null);
                    ((Game_Drone) Car_Agency.get_vehicle()[i]).Energy_score();
                    ((Game_Drone) Car_Agency.get_vehicle()[i]).set_Type(null);

                }
                else if(Car_Agency.get_vehicle()[i] instanceof Amphibious_vehicle){
                    ((Amphibious_vehicle) Car_Agency.get_vehicle()[i]).set_target(null);
                    ((Amphibious_vehicle) Car_Agency.get_vehicle()[i]).set_Because(false);
                    ((Amphibious_vehicle) Car_Agency.get_vehicle()[i]).Average_life_engine();
                    ((Amphibious_vehicle) Car_Agency.get_vehicle()[i]).Average_fuel_consumption();
                    ((Amphibious_vehicle) Car_Agency.get_vehicle()[i]).set_Kind_Way(null);
                    ((Amphibious_vehicle) Car_Agency.get_vehicle()[i]).set_Number_Wheels(0);
                }
            }
            JOptionPane.showMessageDialog(null, "All the values of the vehicles in the system will be reset");
            JOptionPane.showMessageDialog(null, "Insert new vehicles");
            main_window temp=new main_window();
            this.dispose();

        }
        else if(e.getActionCommand().equals("Exit")){
            System.exit(0);
        }
    }
}


