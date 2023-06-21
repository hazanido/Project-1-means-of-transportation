package Graphic;

import Vehicle.Car_Agency;
import Vehicle.Vehicle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


/**
 * This class represents the main frame of the Car Agency program.
 * It extends the JFrame class and implements the ActionListener interface.
 * It displays the available vehicles in the car agency and allows the user to perform various operations on them.
 */
public class Agency_Frame extends JFrame implements ChangeListener  {

    private static Dialog d;
    ImageIcon imageIcon, icon;
    private Vehicle[] Temp_carAgency;
    int finalI;
    private List<Vehicle> vehicles;
    private Threads_class threadsClass;
    private static JButton[] buttons;
    private static boolean[] isTestDriveButtonAdded;





    /**
     * Constructor for the Agency_Frame class.
     * It takes an array of vehicles and a move as parameters.
     * It sets the window properties and displays the available vehicles as buttons with their photos and tooltips.
     */

    public Agency_Frame(List<Vehicle> vehicle) {
        this.setVisible(true);
        this.setSize(1200, 1000);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Agency");
        this.setLayout(new GridLayout());

        vehicles = new ArrayList<>();
        threadsClass = Threads_class.get_Instance();
        //threadsClass = new Threads_class();
        //vehicles = threadsClass.get_Vehicles();
        vehicles.addAll(vehicle);
        //or (int i = 0; i < vehicle.size(); i++) {
        //   vehicles.add(vehicle.get(i));
        //
        buttons = new JButton[vehicles.size()];

        for (int i = 0; i < vehicles.size(); i++) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(vehicles.get(i).get_Photo());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ImageIcon icon = new ImageIcon(image);
            JButton button = new JButton(icon);
            button.setToolTipText(vehicles.get(i).toString());
            button.setActionCommand(String.valueOf(i));
            //button.addActionListener(this);
            buttons[i] = button;
            this.add(button);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    int index = Integer.parseInt(clickedButton.getActionCommand());
                    if (!isTestDriveButtonAdded[index]) {
                        Operations temp = new Operations(index, vehicles);
                        temp.setVisible(true);
                        isTestDriveButtonAdded[index] = true;
                    }
                }
            });


        }
    }


        public void removeAllButtons() {
            if (buttons != null) {
                isTestDriveButtonAdded = new boolean[vehicles.size()];
                for (int i = 0; i < vehicles.size(); i++) {
                    if (isTestDriveButtonAdded[i]) {
                        this.remove(buttons[i]);
                        isTestDriveButtonAdded[i] = false;
                    }
                }
                buttons = null;
            }
        }

        public void change_listener() {
            this.dispose();
            Agency_Frame frame = new Agency_Frame(Threads_class.get_Instance().get_Vehicles());
            frame.setVisible(true);
            frame.removeAllButtons();

        }

}






















