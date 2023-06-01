package Graphic.Vehicle_gui;

import Graphic.Threads_class;
import Graphic.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The Type_Vehicle class is a GUI application that allows users to select
 * the type of transport vehicle they want to use. The available options are:
 * air, land, and marine transport vehicles.
 */
public class Type_Vehicle extends JFrame {

    private JButton Air;
    private JButton Land;
    private JButton Marine;
    private Terrestrial Terrestrial;
    private Maritime Maritime;
    private Aerial Aerial;

    private BufferedImage b_Type_photo;
    private ImageIcon i_Type_photo;

    /**
     * Constructs a Type_Vehicle object.
     * Sets the window properties, adds components to the window and
     * registers the action listeners for each button.
     */
    public Type_Vehicle() {
        // Set window properties

        this.setSize(1200, 670);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Type Vehicle");
        this.setVisible(true);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Type_photo = ImageIO.read(new File("src/Graphic/pictures/Type.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        i_Type_photo = new ImageIcon(b_Type_photo);
        JLabel backgroundLabel = new JLabel(i_Type_photo);

        backgroundLabel.setBounds(0, 0, i_Type_photo.getIconWidth(), i_Type_photo.getIconHeight());
        this.getContentPane().add(backgroundLabel);
        this.add(backgroundLabel);


        // Add components to the window
        Air = new JButton("Air transport vehicles");
        Air.setBounds(0, 550, 400, 80);

        panel.add(Air);
        Air.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Air transport vehicles")) {
                    Aerial = new Aerial();
                    //Threads_class.get_Instance().InProgress();

                }
            }
        });

        Land = new JButton("Land transport vehicle");
        Land.setBounds(400, 550, 400, 80);

        panel.add(Land);
        Land.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Land transport vehicle")) {
                    Terrestrial = new Terrestrial();
                    //Threads_class.get_Instance().InProgress();

                }
            }
        });


        Marine = new JButton("Marine transport vehicle");
        Marine.setBounds(800, 550, 400, 80);
        panel.add(Marine);
        Marine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Marine transport vehicle")) {
                    Maritime = new Maritime();
                    //Threads_class.get_Instance().InProgress();
                }
            }

        });
    }
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

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Marine transport vehicle")) {
            Maritime = new Maritime();

        }
        else if (e.getActionCommand().equals("Land transport vehicle")) {
            Terrestrial = new Terrestrial();


        } else if (e.getActionCommand().equals("Air transport vehicles")) {
            Aerial  = new Aerial();

        }

    }
    */

