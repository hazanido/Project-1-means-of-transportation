// Shiraz Nagaoker 208324194
// Ido hazan-316613769

package Graphic;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
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
    private BufferedImage b_Agency_photo;
    private ImageIcon i_Agency_photo;
    public static main_window instance = null;

    public static void main(String[] args) {
        //new main_window();
        main_window window = main_window.getInstance();    }
    private JButton button;

    /**
     * Constructs a new main_window object and initializes its properties.
     * Sets the window size, location, title, and background color.
     * Adds a button to the window and registers an action listener for it.
     */


    public main_window() {

        // Set window properties

        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Car Agency");
        this.setVisible(true);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Agency_photo = ImageIO.read(new File("src/Graphic/pictures/Agency_car.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        i_Agency_photo = new ImageIcon(b_Agency_photo);
        JLabel backgroundLabel = new JLabel(i_Agency_photo);

        backgroundLabel.setBounds(0, 0, i_Agency_photo.getIconWidth(), i_Agency_photo.getIconHeight());
        this.getContentPane().add(backgroundLabel);
        this.add(backgroundLabel);


        button = new JButton("Adding vehicles");
        button.setBounds(300, 600, 210, 110);
        button.addActionListener(this);

        panel.add(button);


    }
    public static main_window getInstance() {
        if (instance == null)
            instance = new main_window();
        return instance;
    }
    /**
     * Invoked when the button is clicked.
     * Creates a new Type_Vehicle object and disposes of the current window.
     */
    public void actionPerformed(ActionEvent e) {
            Type_Vehicle vehicle = new Type_Vehicle();


    }
}






