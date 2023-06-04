package Graphic.Vehicle_gui;

import Graphic.Agency_Frame;
import Graphic.Vehicle_gui.Type_Vehicle;
import Vehicle.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * The Amphibious class represents a type of vehicle that can move both on land and in water.
 * It extends the JFrame class and implements the ActionListener interface to enable interaction with the user.
 * The class contains various fields that represent the different attributes of the vehicle, such as its model,
 * ability to move, distance traveled, number of passengers, maximum speed, average fuel consumption, and engine lifetime.
 * In addition, the class includes a text field for entering the name of the country to which the vehicle sailed,
 * and radio buttons for choosing whether to sail with or against the wind.
 */

public class Amphibious extends JFrame implements ActionListener {
    private JTextField model,move,distance,passengers,speed,Fuel_consumption,lifetime,flag;
    private JButton add,add_and_closs,add_photo;
    private JRadioButton against, with;

    private JComboBox cb;

    private File f;
    private BufferedImage b_Definitions_photo;
    private ImageIcon i_Definitions_photo;

    /**
     * Constructs a new Amphibious object and initializes its GUI components.
     * The method also initializes all the text fields and labels that will be displayed on the frame,
     * sets their positions and sizes, and adds them to the frame.
     */
    public Amphibious(){
        // Set window properties
        this.setVisible(true);
        this.setSize(300, 840);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Amphibious");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Definitions_photo = ImageIO.read(new File("src/Graphic/pictures/Definitions1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        i_Definitions_photo = new ImageIcon(b_Definitions_photo);
        JLabel backgroundLabel = new JLabel(i_Definitions_photo);

        backgroundLabel.setBounds(0, 0, i_Definitions_photo.getIconWidth(), i_Definitions_photo.getIconHeight());
        this.getContentPane().add(backgroundLabel);
        this.add(backgroundLabel);

        // Add components to the window
        JLabel lebal = new JLabel("model:");
        lebal.setBounds(70, 40, 150, 20);
        panel.add(lebal);

        model=new JTextField();
        model.setBounds(70,60,150,20);
        model.setToolTipText("please enter model of car");
        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(70, 90, 150, 20);
        panel.add(lebal1);
        move=new JTextField();
        move.setBounds(70,110,150,20);
        move.setToolTipText("please enter ability to move the vehicle");
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 140, 150, 20);
        panel.add(lebal2);
        distance=new JTextField();
        distance.setBounds(70,160,150,20);
        distance.setToolTipText("please enter the distance the vehicle traveled during its lifetime");
        JLabel lebal3 = new JLabel("passengers:");
        lebal3.setBounds(70, 190, 150, 20);
        panel.add(lebal3);
        passengers=new JTextField();
        passengers.setBounds(70,210,150,20);
        passengers.setToolTipText("please enter the number of passengers the vehicle contains");
        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 240, 150, 20);
        panel.add(lebal4);
        speed=new JTextField();
        speed.setBounds(70,260,150,20);
        speed.setToolTipText("Please type the maximum speed of the vehicle");

        JLabel lebal5 = new JLabel("Fuel consumption:");
        lebal5.setBounds(70, 290, 150, 20);
        panel.add(lebal5);
        Fuel_consumption=new JTextField();
        Fuel_consumption.setBounds(70,310,150,20);
        Fuel_consumption.setToolTipText("Please enter the average fuel consumption of the vehicle");

        JLabel lebal6 = new JLabel("lifetime:");
        lebal6.setBounds(70, 340, 150, 20);
        panel.add(lebal6);
        lifetime=new JTextField();
        lifetime.setBounds(70,360,150,20);
        lifetime.setToolTipText("Please type the average lifetime of the engine");

        JLabel lebal11 = new JLabel("Flag:");
        lebal11.setBounds(70, 390, 150, 20);
        panel.add(lebal11);
        flag = new JTextField();
        flag.setBounds(70, 410, 150, 20);
        flag.setToolTipText("Please type the name of the country to which the boat sailed");

        JLabel lebal12 = new JLabel("<html>Please Choose whether to<br /> sail with or against the wind ?:</html>");
        lebal12.setBounds(50, 450, 250, 40);
        panel.add(lebal12);
        against = new JRadioButton("against the wind");
        with = new JRadioButton("with the wind");
        against.setBounds(30, 500, 120, 20);
        with.setBounds(160, 500, 110, 20);

        JLabel lebal9 = new JLabel("The kind of way:");
        lebal9.setBounds(90, 530, 150, 20);
        panel.add(lebal9);
        JCheckBox checkbox1 = new JCheckBox("paved");
        checkbox1.setBounds(110,560, 60,30);

        JLabel lebal13 = new JLabel("Select a number of wheels:");
        lebal13.setBounds(70, 590, 250, 40);
        panel.add(lebal13);

        String wheels[] = {"1","2","3","4"};
        cb = new JComboBox(wheels);
        cb.setBounds(70, 620, 120, 20);
        panel.add(cb);

        JLabel lebal10 = new JLabel("Please add photo:");
        lebal10.setBounds(70, 640, 250, 40);
        panel.add(lebal10);

        add_photo = new JButton();
        add_photo.setBounds(100, 670, 90, 50);
        add_photo.setText("add photo");
        add_photo.addActionListener(this);
        panel.add(add_photo);

        add=new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15,740,120,50);
        add.addActionListener(this);


        add_and_closs=new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(145,740,130,50);
        add_and_closs.addActionListener(this);



        panel.add(model);
        panel.add(move);
        panel.add(distance);
        panel.add(passengers);
        panel.add(speed);
        panel.add(Fuel_consumption);
        panel.add(lifetime);
        panel.add(checkbox1);
        panel.add(flag);
        panel.add(against);
        panel.add(with);
        panel.add(add);
        panel.add(add_and_closs);


    }

    /**
     *This method processes an ActionEvent, which is generated when the user interacts with the GUI.
     *
     * The method reads data from various input fields in the GUI, creates a new vehicle object based on the input,
     * If the "add photo" button is pressed, the method opens a file chooser dialog and allows the user to select a photo file,
     * which is then copied to a designated folder.
     * If we click on adding a new vehicle then it will add the vehicle we have just entered to the array
     * and return us to fill in details about the new vehicle we would like to add
     * If we click on adding the vehicle and opening the agency, it will add the vehicle
     * we have just entered to the array of vehicles and open the agency window where there are pictures of all the vehicles in the agency
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("<html>Adding a<br />new vehicle</html>")) {

            String s1=model.getText();
            String s2=move.getText();
            String s3=distance.getText();
            String s4=passengers.getText();
            String s5=speed.getText();
            String s6 = with.getText();
            String s7 = against.getText();
            String s8 = flag.getText();
            String s9 = (String) cb.getSelectedItem();



            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);
            boolean fl = Boolean.parseBoolean(s6);
            boolean fl1 = Boolean.parseBoolean(s7);

            if (fl = true) {
                Amphibious_vehicle temp1=new Amphibious_vehicle(f,s1,s,a,b,c,fl,s8);
                Car_Agency.add_Vehicle(temp1);
            }
            else if (fl1 = true) {
                Amphibious_vehicle temp1=new Amphibious_vehicle(f,s1,s,a,b,c,fl1,s8);
                Car_Agency.add_Vehicle(temp1);

            }


            Type_Vehicle temp = new Type_Vehicle();
            this.dispose();
        }
        else if (e.getActionCommand().equals("add photo")) {
            Path to;

            JFileChooser photo = new JFileChooser();
            int i = photo.showOpenDialog(null);
            f = photo.getSelectedFile();

            to = Paths.get("src/Graphic/pictures/" + f.getName());
            try {
                Files.copy(f.toPath(), to.toFile().toPath());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
        else if (e.getActionCommand().equals("<html>Adding and entering<br />a car dealership</html>")) {
            String s1=model.getText();
            String s2=move.getText();
            String s3=distance.getText();
            String s4=passengers.getText();
            String s5=speed.getText();
            String s6 = with.getText();
            String s7 = against.getText();
            String s8 = flag.getText();



            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);
            boolean fl = Boolean.parseBoolean(s6);
            boolean fl1 = Boolean.parseBoolean(s7);

            if (fl = true) {
                Amphibious_vehicle temp1=new Amphibious_vehicle(f,s1,s,a,b,c,fl,s8);
                Car_Agency.add_Vehicle(temp1);
            }
            else if (fl1 = true) {
                Amphibious_vehicle temp1=new Amphibious_vehicle(f,s1,s,a,b,c,fl1,s8);
                Car_Agency.add_Vehicle(temp1);

            }

            Agency_Frame frame=new Agency_Frame();

            this.dispose();
        }

    }
}
