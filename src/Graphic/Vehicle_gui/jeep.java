package Graphic.Vehicle_gui;

import Graphic.Agency_Frame;
import Graphic.Vehicle_gui.Type_Vehicle;
import Vehicle.Car_Agency;
import Vehicle.Jeep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * The `Jeep` class represents a GUI for adding new vehicle objects to an array.
 * It extends the `JFrame` class and implements the `ActionListener` interface.
 */
public class jeep extends JFrame implements ActionListener {
    private JTextField model, move, distance, passengers, speed, Fuel_consumption, lifetime;
    private JButton add, add_and_closs,add_photo;
    private JComboBox cb;
    private JCheckBox checkbox1;
    private File f;

    /**
     * Constructs a new Jeep object and initializes its GUI components.
     * The method also initializes all the text fields and labels that will be displayed on the frame,
     * sets their positions and sizes, and adds them to the frame.
     */
    public jeep() {
        // Set window properties
        this.setVisible(true);
        this.setSize(300, 770);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Jeep");

        // Add components to the window
        JLabel lebal = new JLabel("model:");
        lebal.setBounds(70, 40, 150, 20);
        this.add(lebal);
        model = new JTextField();
        model.setBounds(70, 60, 150, 20);
        model.setToolTipText("please enter model of car");
        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(70, 90, 150, 20);
        this.add(lebal1);
        move = new JTextField();
        move.setBounds(70, 110, 150, 20);
        move.setToolTipText("please enter ability to move the vehicle");
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 140, 150, 20);
        this.add(lebal2);
        distance = new JTextField();
        distance.setBounds(70, 160, 150, 20);
        distance.setToolTipText("please enter the distance the vehicle traveled during its lifetime");
        JLabel lebal3 = new JLabel("passengers:");
        lebal3.setBounds(70, 190, 150, 20);
        this.add(lebal3);
        passengers = new JTextField();
        passengers.setBounds(70, 210, 150, 20);
        passengers.setToolTipText("please enter the number of passengers the vehicle contains");
        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 240, 150, 20);
        this.add(lebal4);
        speed = new JTextField();
        speed.setBounds(70, 260, 150, 20);
        speed.setToolTipText("Please type the maximum speed of the vehicle");

        JLabel lebal5 = new JLabel("Fuel consumption:");
        lebal5.setBounds(70, 290, 150, 20);
        this.add(lebal5);
        Fuel_consumption = new JTextField();
        Fuel_consumption.setBounds(70, 310, 150, 20);
        Fuel_consumption.setToolTipText("Please enter the average fuel consumption of the vehicle");

        JLabel lebal6 = new JLabel("lifetime:");
        lebal6.setBounds(70, 340, 150, 20);
        this.add(lebal6);
        lifetime = new JTextField();
        lifetime.setBounds(70, 360, 150, 20);
        lifetime.setToolTipText("Please type the average lifetime of the engine");


        JLabel lebal7 = new JLabel("Select a number of wheels:");
        lebal7.setBounds(70, 390, 250, 40);
        this.add(lebal7);
        String wheels[] = {"5"};
        cb = new JComboBox(wheels);
        cb.setBounds(70, 420, 120, 20);
        this.add(cb);

        JLabel lebal8 = new JLabel("Select the license type:");
        lebal8.setBounds(70, 450, 250, 40);
        this.add(lebal8);
        String license[] = {"Mini"};
        JComboBox cb1 = new JComboBox(license);
        cb1.setBounds(75, 480, 120, 20);
        this.add(cb1);

        JLabel lebal9 = new JLabel("The kind of way:");
        lebal9.setBounds(90, 510, 150, 20);
        this.add(lebal9);
        checkbox1 = new JCheckBox("dirt");
        checkbox1.setBounds(110, 540, 60, 30);


        JLabel lebal10 = new JLabel("Please add photo:");
        lebal10.setBounds(70, 570, 250, 40);
        this.add(lebal10);
        add_photo = new JButton();
        add_photo.setBounds(100, 600, 90, 50);
        add_photo.setText("add photo");
        add_photo.addActionListener(this);
        this.add(add_photo);

        add = new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15, 670, 120, 50);
        add.addActionListener(this);


        add_and_closs = new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155, 670, 120, 50);
        add_and_closs.addActionListener(this);


        this.add(model);
        this.add(move);
        this.add(distance);
        this.add(passengers);
        this.add(speed);

        this.add(add);
        this.add(add_and_closs);
        this.add(Fuel_consumption);
        this.add(lifetime);
        this.add(checkbox1);


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
            String s1 = model.getText();
            String s2 = move.getText();
            String s3 = distance.getText();
            String s4 = passengers.getText();
            String s5 = speed.getText();
            String s6 = checkbox1.getText();
            String s7 = (String) cb.getSelectedItem();


            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);
            int d = Integer.parseInt(s7);

            Jeep temp = new Jeep(f, s1, s, a, b, c, d, s6);
            Car_Agency.add_Vehicle(temp);

            Type_Vehicle temp1 = new Type_Vehicle();
            this.dispose();
        } else if (e.getActionCommand().equals("add photo")) {
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
        else if(e.getActionCommand().equals("<html>Adding and entering<br />a car dealership</html>")){
            String s1 = model.getText();
            String s2 = move.getText();
            String s3 = distance.getText();
            String s4 = passengers.getText();
            String s5 = speed.getText();
            String s6 = checkbox1.getText();
            String s7 = (String) cb.getSelectedItem();


            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);
            int d = Integer.parseInt(s7);

            Jeep temp = new Jeep(f, s1, s, a, b, c, d, s6);
            Car_Agency.add_Vehicle(temp);

            Agency_Frame frame=new Agency_Frame(Car_Agency.get_vehicle(),s);

            this.dispose();

        }

    }
}






