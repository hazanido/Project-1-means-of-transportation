package Graphic.Vehicle_gui;

import Graphic.Vehicle_gui.Amphibious;
import Graphic.Vehicle_gui.bicycle;
import Graphic.Vehicle_gui.jeep;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The Terrestrial class represents a graphical window that displays a selection of land transport vehicles.
 * The class implements the ActionListener interface and handles button click events.
 * Allows the user to choose between three types of aerial vehicles: Jeep,Amphibious vehicle and Bicycle.
 */
public class Terrestrial extends JFrame implements ActionListener {
    JButton Jeep;
    JButton Amphibious;
    JButton Bicycle;
    private BufferedImage b_Terrestrial_photo;
    private ImageIcon i_Terrestrial_photo;

    /**
     * Constructs a new Terrestrial object.
     * The constructor initializes the window and adds the buttons to it.
     */
    public Terrestrial(){
        // Set window properties
        this.setVisible(true);
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Land transport vehicle");


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Terrestrial_photo = ImageIO.read(new File("src/Graphic/pictures/TypeP.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        i_Terrestrial_photo = new ImageIcon(b_Terrestrial_photo);
        JLabel backgroundLabel = new JLabel(i_Terrestrial_photo);

        backgroundLabel.setBounds(0, 0, i_Terrestrial_photo.getIconWidth(), i_Terrestrial_photo.getIconHeight());
        this.getContentPane().add(backgroundLabel);
        this.add(backgroundLabel);

        // Add components to the window
        Jeep = new JButton("Jeep");
        Jeep.setBounds(150, 90, 180, 80);
        Jeep.addActionListener(this);
        panel.add(Jeep);
        //this.add(Jeep);
        Amphibious = new JButton("Amphibious vehicle");
        Amphibious.setBounds(150, 250, 180, 80);
        Amphibious.addActionListener(this);
        panel.add(Amphibious);
        //this.add(Amphibious);
        Bicycle = new JButton("Bicycle");
        Bicycle.setBounds(150, 410, 180, 80);
        Bicycle.addActionListener(this);
        panel.add(Bicycle);
        //this.add(Bicycle);

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
