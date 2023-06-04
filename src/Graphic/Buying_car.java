package Graphic;

import Vehicle.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The Buying_car class represents a dialog box for approving the purchase of a car.
 * It displays a message asking the user to confirm whether they want to buy the car or not.
 * If the user confirms the purchase, the car is removed from the car agency and a message is displayed.
 * If there are no more cars in the car agency, the main window is displayed.
 * Otherwise, the agency frame is displayed with the remaining cars.
 */
public class Buying_car extends JDialog implements ChangeListener{


    private Vehicle vehicle;

    /**
     Constructs a new Buying_car dialog box.
     @param i the index of the selected car in the vehicle array
     @param vehicles the array of vehicles in the car agency
     */
    public Buying_car(int i, List<Vehicle> vehicles) {
        this.vehicle = vehicles.get(i);
        this.setTitle("Car purchase approval");
        // Display a message asking the user to confirm the car purchase
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to buy this car?", null, JOptionPane.YES_NO_OPTION);
        // If the user confirms the purchase
        if (option == JOptionPane.YES_OPTION) {
            // Remove the car from the car agency and display a message
            Threads_class.get_Instance().removeVehicle(null,i);
            //Car_Agency.remove_vehicle(Car_Agency.get_vehicle(), i);
            JOptionPane.showMessageDialog(null, "Car has been removed successfully");

            // If there are no more cars in the car agency
            if (i == 0) {
                // Display a message asking the user to insert new vehicles and display the main window
                JOptionPane.showMessageDialog(null, "There are no vehicles at the agency. Insert new vehicles");
                main_window temp = new main_window();
            }

                /**



            } else {
                // Display the agency frame with the remaining cars
                Agency_Frame frame = new Agency_Frame();
                frame.setVisible(true);
                Threads_class.get_Instance().removeVehicle(null,i);
            }
                 */


        }

    }
    public void change_listener(){
        if(Threads_class.get_Instance().get_Vehicles().size()==0){
            this.dispose();
            JOptionPane.showMessageDialog(null, "There are no vehicles at the agency. Insert new vehicles");
            main_window mainWindow = new main_window();
            mainWindow.setVisible(true);
        }
        else{
            this.dispose();
            Agency_Frame frame=new Agency_Frame();
            frame.setVisible(true);


        }


    }
}






