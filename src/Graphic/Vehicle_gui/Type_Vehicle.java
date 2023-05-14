package Graphic.Vehicle_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The Type_Vehicle class is a GUI application that allows users to select
 * the type of transport vehicle they want to use. The available options are:
 * air, land, and marine transport vehicles.
 */
public class Type_Vehicle extends JFrame implements ActionListener{
    private JButton Air;
    private JButton Land;
    private JButton Marine;
    private Graphic.Vehicle_gui.Terrestrial Terrestrial;
    private Graphic.Vehicle_gui.Maritime Maritime;
    private Graphic.Vehicle_gui.Aerial Aerial;
    /**
     * Constructs a Type_Vehicle object.
     * Sets the window properties, adds components to the window and
     * registers the action listeners for each button.
     */
    public Type_Vehicle() {
        // Set window properties
        this.setVisible(true);
        this.setSize(500, 120);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Type Vehicle");
        this.setLayout(new FlowLayout());

        // Add components to the window
        Air = new JButton("Air transport vehicles");
        Air.addActionListener(this);
        this.add(Air);
        Land = new JButton("Land transport vehicle");
        Land.addActionListener(this);
        this.add(Land);
        Marine = new JButton("Marine transport vehicle");
        Marine.addActionListener(this);
        this.add(Marine);


    }

    /**
     * Implements the ActionListener interface to handle button click events.
     * If the user clicks on the Marine transport vehicle button, the program
     * creates a new instance of the Maritime class and disposes the current
     * window. If the user clicks on the Land transport vehicle button, the
     * program creates a new instance of the Terrestrial class and disposes the
     * current window. If the user clicks on the Air transport vehicles button,
     * the program creates a new instance of the Aerial class and disposes the
     * current window.
     * @param e the action event to be handled
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Marine transport vehicle")) {
            Maritime = new Maritime();
            this.dispose();
        }
        else if (e.getActionCommand().equals("Land transport vehicle")) {
            Terrestrial = new Terrestrial();
            this.dispose();

        } else if (e.getActionCommand().equals("Air transport vehicles")) {
            Aerial  = new Aerial();
            this.dispose();
        }

    }

}

