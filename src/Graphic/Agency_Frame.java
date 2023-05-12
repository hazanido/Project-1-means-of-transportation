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


    public Agency_Frame(Car_Agency carAgency, int move) {
        this.carAgency = carAgency;
        this.move = move;

        this.setVisible(true);
        this.setSize(800, 700);
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
            ImageIcon icon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(icon);
            JButton button = new JButton(icon);
            button.setToolTipText(Car_Agency.get_vehicle()[i].toString());
            button.setActionCommand(String.valueOf(i));
            button.addActionListener(this);
            this.add(button);
        }}

        /**



         button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         int selectedIndex = Integer.parseInt(e.getActionCommand());
         //Vehicle selectedVehicle = Temp_carAgency[selectedIndex];


         if (e.getActionCommand().equals("Test drive")) {
         Test_drive frame = new Test_drive(selectedIndex, Temp_carAgency);
         frame.setVisible(true);
         dispose();

         }
         }



         });
         this.add(button);
         **/


    /**
     * public void Operations2(){
     * <p>
     * this.setVisible(true);
     * this.setSize(400, 320);
     * this.setLocationRelativeTo(null);
     * this.setResizable(false);
     * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * this.setLayout(null);
     * this.getContentPane().setBackground(Color.gray);
     * this.setTitle("Operations");
     * <p>
     * <p>
     * test_drive=new JButton("Test drive");
     * buying_car=new JButton("Buying car");
     * Flag_change=new JButton("Flag change");
     * Reset=new JButton("Reset All");
     * Exit=new JButton("Exit");
     * <p>
     * <p>
     * test_drive.setBounds(30,40,150,60);
     * test_drive.addActionListener(this);
     * this.add(test_drive);
     * <p>
     * buying_car.setBounds(200,40,150,60);
     * buying_car.addActionListener(this);
     * this.add(buying_car);
     * <p>
     * Flag_change.setBounds(110,120,150,60);
     * Flag_change.addActionListener(this);
     * this.add(Flag_change);
     * <p>
     * Reset.setBounds(15,240,100,30);
     * Reset.addActionListener(this);
     * this.add(Reset);
     * <p>
     * Exit.setBounds(260,240,100,30);
     * Exit.addActionListener(this);
     * this.add(Exit);
     * <p>
     * <p>
     * <p>
     * }
     **/
    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();
        int index = Integer.parseInt(clickedButton.getActionCommand());
        Vehicle[] vehicles = Car_Agency.get_vehicle();
        Operations temp = new Operations(index, vehicles);
        temp.setVisible(true);
        this.dispose();
    }
}





















