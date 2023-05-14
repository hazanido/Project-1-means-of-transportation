package Graphic.Vehicle_gui;

import Graphic.Vehicle_gui.Amphibious;
import Graphic.Vehicle_gui.bicycle;
import Graphic.Vehicle_gui.jeep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Terrestrial class represents a graphical window that displays a selection of land transport vehicles.
 * The class implements the ActionListener interface and handles button click events.
 * Allows the user to choose between three types of aerial vehicles: Jeep,Amphibious vehicle and Bicycle.
 */
public class Terrestrial extends JFrame implements ActionListener {
    JButton Jeep;
    JButton Amphibious;
    JButton Bicycle;

    /**
     * Constructs a new Terrestrial object.
     * The constructor initializes the window and adds the buttons to it.
     */
    public Terrestrial(){
        // Set window properties
        this.setVisible(true);
        this.setSize(500, 100);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Land transport vehicle");
        this.setLayout(new FlowLayout());

        // Add components to the window
        Jeep = new JButton("Jeep");
        Jeep.setBounds(20, 100, 200, 200);
        Jeep.addActionListener(this);
        this.add(Jeep);
        Amphibious = new JButton("Amphibious vehicle");
        Amphibious.setBounds(300, 100, 200, 200);
        Amphibious.addActionListener(this);
        this.add(Amphibious);
        Bicycle = new JButton("Bicycle");
        Bicycle.setBounds(600, 100, 200, 200);
        Bicycle.addActionListener(this);
        this.add(Bicycle);

    }

    /**
     * Handles button click events.
     * The method creates an instance of the appropriate class for the button that was clicked and disposes of the current window.
     * @param e The button click event.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Jeep")) {
            jeep frame= new jeep();
            this.dispose();
        }
        else if (e.getActionCommand().equals("Amphibious vehicle")) {
            Graphic.Vehicle_gui.Amphibious frame = new Amphibious();
            this.dispose();

        }
        else if (e.getActionCommand().equals("Bicycle")) {
            bicycle frame = new bicycle();
            this.dispose();

        }
    }

}
