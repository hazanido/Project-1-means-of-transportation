package Graphic.Vehicle_gui;

import Graphic.Vehicle_gui.Amphibious;
import Graphic.Vehicle_gui.Cruz;
import Graphic.Vehicle_gui.frigate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The Maritime class represents a graphical window that displays a selection of marine transport vehicles.
 * The class implements the ActionListener interface and handles button click events.
 * Allows the user to choose between three types of aerial vehicles: Frigate,Cruise ship and Amphibious vehicle.
 */
public class Maritime extends JFrame implements ActionListener {
    JButton frigate;
    JButton Cruz;
    JButton Amphibious;

    private BufferedImage b_Maritime_photo;
    private ImageIcon i_Maritime_photo;

    /**
     * Constructs a new Maritime object.
     * The constructor initializes the window and adds the buttons to it.
     */

    public Maritime(){
        // Set window properties
        this.setVisible(true);
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Marine transport vehicle");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Maritime_photo = ImageIO.read(new File("src/Graphic/pictures/TypeP.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        i_Maritime_photo = new ImageIcon(b_Maritime_photo);
        JLabel backgroundLabel = new JLabel(i_Maritime_photo);

        backgroundLabel.setBounds(0, 0, i_Maritime_photo.getIconWidth(), i_Maritime_photo.getIconHeight());
        this.getContentPane().add(backgroundLabel);
        this.add(backgroundLabel);

        // Add components to the window
        frigate = new JButton("Frigate");
        frigate.setBounds(150, 90, 180, 80);
        frigate.addActionListener(this);
        panel.add(frigate);
        //this.add(frigate);
        Cruz = new JButton("Cruise ship");
        Cruz.setBounds(150, 250, 180, 80);
        Cruz.addActionListener(this);
        panel.add(Cruz);
        //this.add(Cruz);
        Amphibious = new JButton("Amphibious vehicle");
        Amphibious.setBounds(150, 410, 180, 80);
        Amphibious.addActionListener(this);
        panel.add(Amphibious);
        //this.add(Amphibious);
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
