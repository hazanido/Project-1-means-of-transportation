package Graphic.Vehicle_gui;

import Factory.AerialFactory;
import Factory.TerrestrialFactory;
import Vehicle.ElectricBicycle;
import Vehicle.NonMotorizedBicycle;

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

    private JButton Jeep,Amphibious,Bicycle,Electric_Bicycle,Hybrid_Plane;

    private BufferedImage b_Terrestrial_photo,b_Jeep_photo,b_Amphibious_photo,b_Bicycle_photo,b_Electric_Bicycle,b_Hybrid_Plane;
    private ImageIcon i_Terrestrial_photo,i_Jeep_photo,i_Amphibious_photo,i_Bicycle_photo,i_Electric_Bicycle,i_Hybrid_Plane;
    private JLabel Jeep_photo,Amphibious_photo,Bicycle_photo,Electric_Bicycle_photo,Hybrid_Plane_photo;
    private boolean isJeepSelected;
    private boolean isAmphibiousSelected;
    private boolean isBicycleSelected;
    private boolean isElectricBicycleSelected;
    private boolean isHybridPlaneSelected;
    private TerrestrialFactory factory;
    /**
     * Constructs a new Terrestrial object.
     * The constructor initializes the window and adds the buttons to it.
     */
    public Terrestrial(TerrestrialFactory factory){
        this.factory = factory;
        // Set window properties
        this.setVisible(true);
        this.setSize(900, 630);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Land transport vehicle");
        isJeepSelected=false;
        isAmphibiousSelected=false;
        isBicycleSelected=false;
        isElectricBicycleSelected=false;
        isHybridPlaneSelected=false;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Terrestrial_photo = ImageIO.read(new File("src/Graphic/pictures/land.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        i_Terrestrial_photo = new ImageIcon(b_Terrestrial_photo);
        JLabel backgroundLabel = new JLabel(i_Terrestrial_photo);

        backgroundLabel.setBounds(0, 0, i_Terrestrial_photo.getIconWidth(), i_Terrestrial_photo.getIconHeight());
        this.getContentPane().add(backgroundLabel);
        this.add(backgroundLabel);

        try {
            b_Jeep_photo = ImageIO.read(new File("src/Graphic/pictures/jeep.png"));
            b_Amphibious_photo = ImageIO.read(new File("src/Graphic/pictures/Amphibious.png"));
            b_Bicycle_photo = ImageIO.read(new File("src/Graphic/pictures/Bicycle.png"));
            b_Electric_Bicycle = ImageIO.read(new File("src/Graphic/pictures/ElectricBicycle.png"));
            b_Hybrid_Plane = ImageIO.read(new File("src/Graphic/pictures/hybrid_plane.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        i_Jeep_photo=new ImageIcon(b_Jeep_photo);
        i_Amphibious_photo=new ImageIcon(b_Amphibious_photo);
        i_Bicycle_photo=new ImageIcon(b_Bicycle_photo);
        i_Electric_Bicycle=new ImageIcon(b_Electric_Bicycle);
        i_Hybrid_Plane=new ImageIcon(b_Hybrid_Plane);

        Jeep_photo=new JLabel(i_Jeep_photo);
        Jeep_photo.setBounds(300,390,90,45);
        panel.add(Jeep_photo);

        Amphibious_photo=new JLabel(i_Amphibious_photo);
        Amphibious_photo.setBounds(190,170,90,50);
        panel.add(Amphibious_photo);

        Bicycle_photo=new JLabel(i_Bicycle_photo);
        Bicycle_photo.setBounds(390,170,90,50);
        panel.add(Bicycle_photo);

        Electric_Bicycle_photo=new JLabel(i_Electric_Bicycle);
        Electric_Bicycle_photo.setBounds(590,170,90,50);
        panel.add(Electric_Bicycle_photo);

        Hybrid_Plane_photo=new JLabel(i_Hybrid_Plane);
        Hybrid_Plane_photo.setBounds(510,390,90,50);
        panel.add(Hybrid_Plane_photo);

        // Add components to the window
        Jeep = new JButton("Jeep");
        Jeep.setBounds(260, 300, 180, 80);
        Jeep.addActionListener(this);
        panel.add(Jeep);

        Amphibious = new JButton("Amphibious vehicle");
        Amphibious.setBounds(160, 80, 180, 80);
        Amphibious.addActionListener(this);
        panel.add(Amphibious);

        Bicycle = new JButton("Bicycle");
        Bicycle.setBounds(360, 80, 180, 80);
        Bicycle.addActionListener(this);
        panel.add(Bicycle);

        Electric_Bicycle= new JButton("Electric Bicycle");
        Electric_Bicycle.setBounds(560, 80, 180, 80);
        Electric_Bicycle.addActionListener(this);
        panel.add(Electric_Bicycle);

        Hybrid_Plane=new JButton("Hybrid Plane");
        Hybrid_Plane.setBounds(470,300,180,80);
        Hybrid_Plane.addActionListener(this);
        panel.add(Hybrid_Plane);


    }

    /**
     * Handles button click events.
     * The method creates an instance of the appropriate class for the button that was clicked and disposes of the current window.
     * @param e The button click event.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Jeep")) {
            jeep frame= new jeep();
            frame.setVisible(true);
            isJeepSelected=true;
            factory.produceVehicle();
        }
        else if (e.getActionCommand().equals("Amphibious vehicle")) {
            Amphibious frame = new Amphibious();
            frame.setVisible(true);
            isAmphibiousSelected=true;
            factory.produceVehicle();
        }
        else if (e.getActionCommand().equals("Bicycle")) {
            Non_Motorized_bicycle frame = new Non_Motorized_bicycle();
            frame.setVisible(true);
            isBicycleSelected=true;
            factory.produceVehicle();
        }
        else if(e.getActionCommand().equals("Electric Bicycle")){
            electric_bicycle frame=new electric_bicycle();
            frame.setVisible(true);
            isElectricBicycleSelected=true;
            factory.produceVehicle();
        }
        else if(e.getActionCommand().equals("Hybrid Plane")){
            hybrid_plane frame=new hybrid_plane();
            frame.setVisible(true);
            isHybridPlaneSelected=true;
            factory.produceVehicle();
        }
    }
    public String getSelectedTerrestrial() {
        if(isJeepSelected){
            return "Jeep";
        }
        else if(isAmphibiousSelected){
            return "Amphibious";
        }
        else if(isBicycleSelected){
            return "Bicycle";
        }
        else if(isElectricBicycleSelected){
            return "Electric_Bicycle";
        }
        else if(isHybridPlaneSelected){
            return "Hybrid_Plane";
        }
        return null;
    }


}
