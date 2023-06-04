package Graphic;

import Vehicle.Car_Agency;
import Vehicle.Vehicle;
import Vehicle.*;
import Vehicle.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * This class represents the main frame of the Car Agency program.
 * It extends the JFrame class and implements the ActionListener interface.
 * It displays the available vehicles in the car agency and allows the user to perform various operations on them.
 */
public class Agency_Frame extends JFrame  {

    JLabel display;
    private static Dialog d;
    ImageIcon imageIcon, icon;
    private Vehicle[] Temp_carAgency;
    int finalI;
    private List<Vehicle> vehicles;
    private Threads_class threadsClass;

    private Car_Agency carAgency;
    //private JButton[] buttons;
    private int move;
    //private JButton test_drive, buying_car, Flag_change, Reset, Exit;

    /**
     * Constructor for the Agency_Frame class.
     * It takes an array of vehicles and a move as parameters.
     * It sets the window properties and displays the available vehicles as buttons with their photos and tooltips.
     */

    public Agency_Frame() {
        this.setVisible(true);
        this.setSize(1200, 1000);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Agency");
        this.setLayout(new GridLayout());

        threadsClass = new Threads_class();
        vehicles = threadsClass.get_Vehicles();

        for (int i = 0; i < Car_Agency.get_vehicle().length; i++) {
            vehicles.add(i, Car_Agency.get_vehicle()[i]);
        }


        for (int i = 0; i < vehicles.size(); i++) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(vehicles.get(i).get_Photo());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ImageIcon icon = new ImageIcon(image);
            JButton button = new JButton(icon);
            button.setToolTipText(vehicles.toString());
            button.setActionCommand(String.valueOf(i));
            //button.addActionListener(this);
            this.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    int index = Integer.parseInt(clickedButton.getActionCommand());


                    //Vehicle[] vehiclesArray = vehicles.toArray(new Vehicle[0]);

                    //Vehicle[] vehiclesArray = new Vehicle[vehicles.size()];
                    //vehicles.toArray(vehiclesArray);
                    //Vehicle[] vehiclesArray = vehicles.toArray(new Vehicle[vehicles.size()]);
                    Operations temp = new Operations(index, vehicles);
                    temp.setVisible(true);
                }
            });
        }


        //this.threadsClass = Threads_class.get_Instance();
        //this.vehicles = this.threadsClass.getVehicles();

        //this.carAgency = carAgency;
        //this.move = move;
        //Threads_class.get_Instance().addListener(this);

        //this.vehicles = new ArrayList<>();

        //for (int i = 0; i < vehicles.length; i++) {
        //this.vehicles.add(vehicles[i]);

        //}

    }
}


         /**
        Temp_carAgency=new Vehicle[Threads_class.get_Instance().get_Vehicles().size()];
        for (int i=0;i<Threads_class.get_Instance().get_Vehicles().size();i++){
            Temp_carAgency[i]= Threads_class.get_Instance().get_Vehicles().get(i);
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
            setVisible(true);
            this.add(button);
          */

        /**
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            BufferedImage image;
            try {
                image = ImageIO.read(vehicles.get(i).get_Photo());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ImageIcon icon = new ImageIcon(image);
            JButton button = new JButton(icon);
            button.setToolTipText(vehicle.toString());
            button.setPreferredSize(new Dimension(300, 200));
            //button.setActionCommand(String.valueOf(i));
            button.addActionListener(this);
            //buttons[i] = button;
            this.add(button);
        }

        setVisible(true);
         */

    /**


     java.util.List<Vehicle> vehicles = Threads_class.get_Instance().get_Vehicles();



        // Copy the vehicles array to the Temp_carAgency array
        /**
        Temp_carAgency = new Vehicle[Car_Agency.get_vehicle().length];
        for (int i = 0; i < Car_Agency.get_vehicle().length; i++) {
            Temp_carAgency[i] = Car_Agency.get_vehicle()[i];
        }

        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            BufferedImage image;
            try {
                image = ImageIO.read(vehicle.get_Photo());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ImageIcon icon = new ImageIcon(image);
            JButton button = new JButton(icon);
            button.setToolTipText(vehicle.toString());
            button.setActionCommand(String.valueOf(i));
            button.addActionListener(this);
            buttons[i] = button;
            add(button);
        }
        setVisible(true);



        Temp_carAgency = new Vehicle[vehicles.size()];
        for (int i=0;i<vehicles.size();i++){
            Temp_carAgency[i] = vehicles.get(i);
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
    /**

    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();
        int index = Integer.parseInt(clickedButton.getActionCommand());


        //Vehicle[] vehiclesArray = vehicles.toArray(new Vehicle[0]);

        //Vehicle[] vehiclesArray = new Vehicle[vehicles.size()];
        //vehicles.toArray(vehiclesArray);
        //Vehicle[] vehiclesArray = vehicles.toArray(new Vehicle[vehicles.size()]);
        Operations temp = new Operations(index,vehicles);
        temp.setVisible(true);


    }
     */






















