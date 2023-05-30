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
import javax.imageio.ImageIO;

/**
 * The Maritime class represents a graphical window that displays a selection of marine transport vehicles.
 * The class implements the ActionListener interface and handles button click events.
 * Allows the user to choose between three types of aerial vehicles: Frigate,Cruise ship and Amphibious vehicle.
 */
public class Maritime extends JFrame implements ActionListener {

    private JButton frigate,Cruz,Amphibious,Hybrid_Plane;
    private BufferedImage b_Maritime_photo,b_frigate,b_cruise,b_amphibious,b_Hybrid_Plane;
    private ImageIcon i_Maritime_photo,i_frigate,i_cruise,i_amphibious,i_Hybrid_Plane;
    private JLabel frigate_photo,Cruz_photo,Amphibious_photo,Hybrid_Plane_photo;
    /**
     * Constructs a new Maritime object.
     * The constructor initializes the window and adds the buttons to it.
     */

    public Maritime(){
        // Set window properties
        this.setVisible(true);
        this.setSize(850, 665);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Marine transport vehicle");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Maritime_photo =  ImageIO.read(new File("src/Graphic/pictures/sea.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        i_Maritime_photo = new ImageIcon(b_Maritime_photo);
        JLabel backgroundLabel = new JLabel(i_Maritime_photo);

        backgroundLabel.setBounds(0, 0, i_Maritime_photo.getIconWidth(), i_Maritime_photo.getIconHeight());
        this.getContentPane().add(backgroundLabel);
        this.add(backgroundLabel);

        try {
            b_frigate = ImageIO.read(new File("src/Graphic/pictures/Frigate.png"));
            b_cruise = ImageIO.read(new File("src/Graphic/pictures/Cruise.png"));
            b_amphibious = ImageIO.read(new File("src/Graphic/pictures/Amphibious.png"));
            b_Hybrid_Plane = ImageIO.read(new File("src/Graphic/pictures/hybrid_plane.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        i_frigate=new ImageIcon(b_frigate);
        i_cruise=new ImageIcon(b_cruise);
        i_amphibious=new ImageIcon(b_amphibious);
        i_Hybrid_Plane=new ImageIcon(b_Hybrid_Plane);

        frigate_photo=new JLabel(i_frigate);
        frigate_photo.setBounds(270,390,90,45);
        panel.add(frigate_photo);

        Cruz_photo=new JLabel(i_cruise);
        Cruz_photo.setBounds(260,170,90,60);
        panel.add(Cruz_photo);

        Amphibious_photo=new JLabel(i_amphibious);
        Amphibious_photo.setBounds(460,170,90,50);
        panel.add(Amphibious_photo);

        Hybrid_Plane_photo=new JLabel(i_Hybrid_Plane);
        Hybrid_Plane_photo.setBounds(470,390,90,50);
        panel.add(Hybrid_Plane_photo);


        // Add components to the window
        frigate = new JButton("Frigate");
        frigate.setBounds(230, 300, 180, 80);
        frigate.addActionListener(this);
        panel.add(frigate);
        //this.add(frigate);
        Cruz = new JButton("Cruise ship");
        Cruz.setBounds(230, 80, 180, 80);
        Cruz.addActionListener(this);
        panel.add(Cruz);
        //this.add(Cruz);
        Amphibious = new JButton("Amphibious vehicle");
        Amphibious.setBounds(430, 80, 180, 80);
        Amphibious.addActionListener(this);
        panel.add(Amphibious);

        Hybrid_Plane=new JButton("Hybrid Plane");
        Hybrid_Plane.setBounds(430,300,180,80);
        Hybrid_Plane.addActionListener(this);
        panel.add(Hybrid_Plane);
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
        else if(e.getActionCommand().equals("Hybrid Plane")){
            hybrid_plane frame=new hybrid_plane();
            this.dispose();
        }
    }
}
