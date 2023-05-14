package Graphic.Vehicle_gui;

import Graphic.Vehicle_gui.Amphibious;
import Graphic.Vehicle_gui.Cruz;
import Graphic.Vehicle_gui.frigate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Maritime class represents a graphical window that displays a selection of marine transport vehicles.
 * The class implements the ActionListener interface and handles button click events.
 * Allows the user to choose between three types of aerial vehicles: Frigate,Cruise ship and Amphibious vehicle.
 */
public class Maritime extends JFrame implements ActionListener {
    JButton frigate;
    JButton Cruz;
    JButton Amphibious;

    /**
     * Constructs a new Maritime object.
     * The constructor initializes the window and adds the buttons to it.
     */

    public Maritime(){
        // Set window properties
        this.setVisible(true);
        this.setSize(500, 100);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Marine transport vehicle");
        this.setLayout(new FlowLayout());

        // Add components to the window
        frigate = new JButton("Frigate");
        frigate.setBounds(20, 100, 200, 200);
        frigate.addActionListener(this);
        this.add(frigate);
        Cruz = new JButton("Cruise ship");
        Cruz.setBounds(300, 100, 200, 200);
        Cruz.addActionListener(this);
        this.add(Cruz);
        Amphibious = new JButton("Amphibious vehicle");
        Amphibious.setBounds(600, 100, 200, 200);
        Amphibious.addActionListener(this);
        this.add(Amphibious);
    }
    /**
     * Handles button click events.
     * The method creates an instance of the appropriate class for the button that was clicked and disposes of the current window.
     * @param e The button click event.
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Frigate")) {
            Graphic.Vehicle_gui.frigate frame= new frigate();
            this.dispose();
        }
        else if (e.getActionCommand().equals("Cruise ship")) {
            Graphic.Vehicle_gui.Cruz frame = new Cruz();
            this.dispose();

        }
        else if (e.getActionCommand().equals("Amphibious vehicle")) {
            Graphic.Vehicle_gui.Amphibious frame = new Amphibious();
            this.dispose();

        }
    }
}
