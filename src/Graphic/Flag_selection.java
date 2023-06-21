package Graphic;

import Vehicle.Vehicle;
import Vehicle.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *This class represents a frame that allows the user to select a flag for marine transport vehicles.
 *It extends the JFrame class and implements the ActionListener interface.
 *It contains several JButton components that represent different flags, and allows the user to select one of them.
 *Once a button is clicked, the name of the flag is extracted from the button and used to set the target flag of all relevant vehicles in the Car_Agency.
 *The class also creates a new Agency_Frame object once a button is clicked.
 */

public class Flag_selection extends JFrame implements ActionListener {

    private JButton Back, israel, usa, germany, greece, italy, sumulia, pirates;
    private JTextField move;
    private Vehicle vehicle;
    private int i;

    private BufferedImage b_israel,b_usa,b_germany,b_greece,b_italy,b_sumulia,b_pirates;

    private ImageIcon i_israel,i_usa,i_germany,i_greece,i_italy,i_sumulia,i_pirates;

    /**
     *Constructor for Flag_selection class.
     *Initializes the window properties, loads the images and creates the JButtons.
     *Also sets the ActionListener for each button.
     *@param i An integer representing the index of the selected vehicle in the Car_Agency.
     *@param vehicles An array of Vehicle objects representing the vehicles in the Car_Agency.
     */

    public Flag_selection(int i, List<Vehicle> vehicles) {

        // Set window properties
        this.vehicle = vehicles.get(i);
        this.setVisible(true);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,3));
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Flag selection");

        // Load images
        try {
            b_germany = ImageIO.read(new File("src/Graphic/pictures/Germany.png"));
            b_israel = ImageIO.read(new File("src/Graphic/pictures/israel.png"));
            b_usa = ImageIO.read(new File("src/Graphic/pictures/usa.png"));
            b_greece = ImageIO.read(new File("src/Graphic/pictures/Greece.png"));
            b_italy = ImageIO.read(new File("src/Graphic/pictures/Italy.png"));
            b_sumulia = ImageIO.read(new File("src/Graphic/pictures/sumulia.png"));
            b_pirates = ImageIO.read(new File("src/Graphic/pictures/Pirates.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Create ImageIcons from the loaded images
        i_germany=new ImageIcon(b_germany);
        i_israel=new ImageIcon(b_israel);
        i_usa=new ImageIcon(b_usa);
        i_greece=new ImageIcon(b_greece);
        i_italy=new ImageIcon(b_italy);
        i_sumulia=new ImageIcon(b_sumulia);
        i_pirates=new ImageIcon(b_pirates);

        // Create JButtons
        germany=new JButton(i_germany);
        israel=new JButton(i_israel);
        usa=new JButton(i_usa);
        greece=new JButton(i_greece);
        italy=new JButton(i_italy);
        sumulia=new JButton(i_sumulia);
        pirates=new JButton(i_pirates);

        // Set ActionListener for each button
        germany.addActionListener(this);
        israel.addActionListener(this);
        usa.addActionListener(this);
        greece.addActionListener(this);
        italy.addActionListener(this);
        sumulia.addActionListener(this);
        pirates.addActionListener(this);

        // Set name for each button
        germany.setName("Germany");
        israel.setName("Israel");
        usa.setName("USA");
        greece.setName("Greece");
        italy.setName("Italy");
        sumulia.setName("Sumulia");
        pirates.setName("Pirates");


        this.add(germany);
        this.add(israel);
        this.add(usa);
        this.add(greece);
        this.add(italy);
        this.add(sumulia);
        this.add(pirates);

    }

    /**
     *This method is invoked when a button is clicked in the Flag_selection frame.
     *It sets the target flag filename to the Marine_transport_vehicle objects in the Car_Agency array
     *that are instances of Frigate, Cruise_ship or Amphibious_vehicle.
     *Then it creates an instance of Agency_Frame to display the updated state of the vehicles.
     *@param e - the ActionEvent object that triggered the method call
     */


    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();
        String flagFilename =  clickedButton.getName() ;

        for (int i = 0; i < Car_Agency.get_vehicle().length; i++) {
            if((Car_Agency.get_vehicle()[i] instanceof Frigate) || (Car_Agency.get_vehicle()[i] instanceof Cruise_ship) ||(Car_Agency.get_vehicle()[i] instanceof Amphibious_vehicle)){
                ((Marine_transport_vehicle) Car_Agency.get_vehicle()[i]).set_target(flagFilename);
            }
        }
        Agency_Frame temp1=new Agency_Frame(Threads_class.get_Instance().get_Vehicles());

    }

}