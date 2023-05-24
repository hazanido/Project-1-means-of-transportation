package Graphic.Vehicle_gui;

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
public class Type_Vehicle extends JFrame implements ActionListener{

    private JButton Air;
    private JButton Land;
    private JButton Marine;
    private Graphic.Vehicle_gui.Terrestrial Terrestrial;
    private Graphic.Vehicle_gui.Maritime Maritime;
    private Graphic.Vehicle_gui.Aerial Aerial;

    private BufferedImage b_Type_photo;
    private ImageIcon i_Type_photo;
    /**
     * Constructs a Type_Vehicle object.
     * Sets the window properties, adds components to the window and
     * registers the action listeners for each button.
     */
    public Type_Vehicle() {
        // Set window properties

        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            b_Type_photo = ImageIO.read(new File("src/Graphic/pictures/TypeP.png"));
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
        Air.setBounds(210,120, 250, 100);
        Air.addActionListener(this);

        panel.add(Air);
        //this.add(Air);
        Land = new JButton("Land transport vehicle");
        Land.setBounds(210, 270, 250, 100);
        Land.addActionListener(this);

        panel.add(Land);
        //this.add(Land);
        Marine = new JButton("Marine transport vehicle");
        Marine.setBounds(210, 430, 250, 100);
        Marine.addActionListener(this);

        panel.add(Marine);
        //this.add(Marine);


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

