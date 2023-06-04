package Graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import Vehicle.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * This class represents a GUI window for performing operations on a Vehicle object.
 * The class extends JFrame and implements ActionListener interface.
 * It contains buttons for test driving a vehicle, buying a vehicle, changing flag and resetting all the vehicles data.
 */


public class Operations extends JFrame implements ChangeListener {

    private Vehicle vehicle;
    private int i;
    private JButton test_drive, buying_car, Flag_change, Reset, Current_Inventory_Report, Exit;
    private List<Vehicle> vehicles;
    private BufferedImage b_Operations_photo;
    private ImageIcon i_Operations_photo;

    /**
     * Constructor for the Operations class. Initializes instance variables and sets up the GUI window.
     *
     * @param i        The index of the vehicle in the array of vehicles passed to the constructor.
     * @param vehicles An array of Vehicle objects.
     */

    public Operations(int i, List<Vehicle> vehicles) {
        this.i = i;
        this.vehicles=vehicles;

        // Set window properties
        this.setVisible(true);
        this.setSize(400, 320);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Operations");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Operations_photo = ImageIO.read(new File("src/Graphic/pictures/Operations.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        i_Operations_photo = new ImageIcon(b_Operations_photo);
        JLabel backgroundLabel = new JLabel(i_Operations_photo);

        backgroundLabel.setBounds(0, 0, i_Operations_photo.getIconWidth(), i_Operations_photo.getIconHeight());
        this.getContentPane().add(backgroundLabel);
        this.add(backgroundLabel);


        test_drive = new JButton("Test drive");
        buying_car = new JButton("Buying car");
        Flag_change = new JButton("Flag change");
        Current_Inventory_Report = new JButton("<html>Current Inventory<br />Report</html>");
        Reset = new JButton("Reset All");
        Exit = new JButton("Exit");


        test_drive.setBounds(30, 40, 150, 60);

        panel.add(test_drive);
        test_drive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!Threads_class.get_Instance().Inspection_by_type(i)) {
                    Test_drive testDrive = new Test_drive(i, vehicles);
                    testDrive.setVisible(true);
                }
                else {
                    try {
                        throw new IllegalStateException("This vehicle is currently being test driven. Please try again later.");
                    } catch (IllegalStateException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });

        buying_car.setBounds(200, 40, 150, 60);
        panel.add(buying_car);
        buying_car.addActionListener(e -> Buy(i));


        Flag_change.setBounds(30, 120, 150, 60);
        panel.add(Flag_change);
        Flag_change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flag_selection flag = new Flag_selection(i, vehicles);
                flag.setVisible(true);
            }
        });

        Current_Inventory_Report.setBounds(200, 120, 150, 60);
        panel.add(Current_Inventory_Report);
        Current_Inventory_Report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventory_Report frame = new Inventory_Report();
                frame.setVisible(true);

            }
        });

        Reset.setBounds(15, 240, 100, 30);
        panel.add(Reset);
        Reset.addActionListener(e -> Threads_class.get_Instance().resetAll(this));

        Exit.setBounds(260, 240, 100, 30);
        panel.add(Exit);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Threads_class.get_Instance().InProgress()) {
                    JOptionPane.showMessageDialog(null, "Unable to log out because the program is still in progress - try again later");

                }
                for (Window window : Window.getWindows()) {
                    window.dispose();
                }
                System.gc();
                System.exit(0);

            }
        });

    }

    private void Buy(int index) {
        if (Threads_class.get_Instance().Inspection_by_index(index)) {
            JOptionPane.showMessageDialog(null, "Vehicle type is current in test - please try again later");
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {

        }
        int result = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {

            Threads_class.get_Instance().removeVehicle(this, index);
            dispose();
            Buying_car buyVehicleWindow = new Buying_car(index, vehicles);
            buyVehicleWindow.setVisible(true);
        }


    }
    public void change_listener(){
        test_drive.removeAll();
        buying_car.removeAll();
        Flag_change.removeAll();
        Reset.removeAll();
        Exit.removeAll();


        test_drive.revalidate();
        test_drive.repaint();

        buying_car.revalidate();
        buying_car.repaint();

        Flag_change.revalidate();
        Flag_change.repaint();

        Reset.revalidate();
        Reset.repaint();

        Exit.revalidate();
        Exit.repaint();
        invalidate();
        validate();
        repaint();
    }

}


    /**
     * Action listener method for the buttons in the GUI window.
     * @param e An ActionEvent object.


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Test drive")) {
            Test_drive frame = new Test_drive(i, vehicles);
            //SwingUtilities.invokeLater(new Test_drive(i,vehicles));


        }
        else if (e.getActionCommand().equals("Buying car")) {

                Buying_car frame = new Buying_car(i, vehicles);


        }
        else if(e.getActionCommand().equals("Flag change")){
            Flag_selection frame=new Flag_selection(i,vehicles);
            frame.setVisible(true);



        }
        else if(e.getActionCommand().equals("<html>Current Inventory<br />Report</html>")){
            Inventory_Report frame=new Inventory_Report();
            frame.setVisible(true);

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
                else if(Car_Agency.get_vehicle()[i] instanceof NonMotorizedBicycle){
                    ((NonMotorizedBicycle) Car_Agency.get_vehicle()[i]).set_Number_Wheels(0);
                    ((NonMotorizedBicycle) Car_Agency.get_vehicle()[i]).set_Kind_Way(null);
                    ((NonMotorizedBicycle) Car_Agency.get_vehicle()[i]).Energy_score();
                    ((NonMotorizedBicycle) Car_Agency.get_vehicle()[i]).power_source(null);
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
                else if(Car_Agency.get_vehicle()[i] instanceof ElectricBicycle){
                    ((ElectricBicycle) Car_Agency.get_vehicle()[i]).set_Number_Wheels(0);
                    ((ElectricBicycle) Car_Agency.get_vehicle()[i]).Average_fuel_consumption();
                    ((ElectricBicycle) Car_Agency.get_vehicle()[i]).Average_life_engine();
                    ((ElectricBicycle) Car_Agency.get_vehicle()[i]).set_Kind_Way(null);
                }
                else if(Car_Agency.get_vehicle()[i] instanceof Hybrid_plane){
                    ((Hybrid_plane) Car_Agency.get_vehicle()[i]).set_Kind_Way(null);
                    ((Hybrid_plane) Car_Agency.get_vehicle()[i]).set_Type(null);
                    ((Hybrid_plane) Car_Agency.get_vehicle()[i]).Average_life_engine();
                    ((Hybrid_plane) Car_Agency.get_vehicle()[i]).Average_fuel_consumption();
                    ((Hybrid_plane) Car_Agency.get_vehicle()[i]).set_Because(false);
                    ((Hybrid_plane) Car_Agency.get_vehicle()[i]).set_target(null);
                }
            }
            JOptionPane.showMessageDialog(null, "All the values of the vehicles in the system will be reset");
            JOptionPane.showMessageDialog(null, "Insert new vehicles");
            main_window temp=new main_window();


        }
        else if(e.getActionCommand().equals("Exit")){
            Exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Threads_class.get_Instance().InProgress()){
                        JOptionPane.showMessageDialog(null,"Operation failed, program in progress, try again later");

                    }
                    for(Window frame:Window.getWindows()){
                        frame.dispose();
                    }
                    System.gc();
                    System.exit(0);
                }
            });

        }
    }
    */



