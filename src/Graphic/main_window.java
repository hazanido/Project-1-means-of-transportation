package Graphic;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Graphic.Vehicle_gui.Type_Vehicle;

/**
 * The main_window class represents the main window of the Car Agency application.
 * It extends the JFrame class and implements the ActionListener interface.
 * It contains a button that opens the Type_Vehicle window when clicked.
 */
public class main_window extends JFrame implements ActionListener {
    private ImageIcon logo;
    private JLabel label1;
    private Type_Vehicle vehicle;
    public static void main(String[] args) {
        new main_window();

    }

    private JButton button;


    /**
     *Constructs a new main_window object and initializes its properties.
     *Sets the window size, location, title, and background color.
     *Adds a button to the window and registers an action listener for it.
     */
    public main_window() {


        // Set window properties
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Car Agency");
        this.setVisible(true);



        button = new JButton("Adding vehicles");
        button.setBounds(90, 60, 210, 110);
        button.addActionListener(this);
        this.add(button);

    }

    /**
     Invoked when the button is clicked.
     Creates a new Type_Vehicle object and disposes of the current window.
     */
    public void actionPerformed(ActionEvent e){
        Type_Vehicle vehicle=new Type_Vehicle();
        this.dispose();

    }

}


