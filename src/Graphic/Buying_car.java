package Graphic;

import Vehicle.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buying_car extends JDialog implements ActionListener {
    private Vehicle vehicle;
    public Buying_car(int i, Vehicle[] vehicles){
        this.vehicle = vehicles[i];
        this.setTitle("Car purchase approval");
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to buy this car?", "Car purchase approval", JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION) {
            Car_Agency.remove_vehicle(Car_Agency.get_vehicle(),i);
            JOptionPane.showMessageDialog(null, "Car has been removed successfully");
            this.dispose();
            if(i==0){
                JOptionPane.showMessageDialog(null, "There are no vehicles at the agency. Insert new vehicles");
                main_window temp=new main_window();
                this.dispose();

            }else {
                Agency_Frame frame = new Agency_Frame(Car_Agency.get_vehicle(), vehicle.get_move());
                frame.setVisible(true);
            }

    }

}


    public void actionPerformed(ActionEvent e) {


    }


}
