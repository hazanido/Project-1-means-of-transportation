package Graphic.Vehicle_gui;

import Graphic.Agency_Frame;
import Graphic.Vehicle_gui.Type_Vehicle;
import Vehicle.Car_Agency;
import Vehicle.Game_Drone;

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
 * The `game drone` class represents a GUI for adding new vehicle objects to an array.
 * It extends the `JFrame` class and implements the `ActionListener` interface.
 */
public class game_drone extends JFrame implements ActionListener {
    private JTextField move, distance;
    private JButton add, add_and_closs, add_photo;
    private JComboBox cb5, cb6, cb4, cb1;
    private JRadioButton manual, civilian;
    private File f;

    /**
     * Constructs a new Game drone object and initializes its GUI components.
     * The method also initializes all the text fields and labels that will be displayed on the frame,
     * sets their positions and sizes, and adds them to the frame.
     */

    public game_drone() {
        // Set window properties
        this.setVisible(true);
        this.setSize(300, 620);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Game drone");

        // Add components to the window
        JLabel lebal = new JLabel("model:");
        lebal.setBounds(70, 40, 150, 20);
        this.add(lebal);
        String model[] = {"Toy"};
        cb5 = new JComboBox(model);
        cb5.setBounds(110, 40, 90, 20);
        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(70, 70, 150, 20);
        this.add(lebal1);
        move = new JTextField();
        move.setBounds(70, 90, 150, 20);
        move.setToolTipText("please enter ability to move the vehicle");
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 120, 150, 20);
        this.add(lebal2);
        distance = new JTextField();
        distance.setBounds(70, 140, 150, 20);
        distance.setToolTipText("please enter the distance the vehicle traveled during its lifetime");
        JLabel lebal3 = new JLabel("Max passengers:");
        lebal3.setBounds(70, 170, 150, 20);
        this.add(lebal3);
        String passengers[] = {"0"};
        cb6 = new JComboBox(passengers);
        cb6.setBounds(180, 170, 50, 20);

        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 200, 150, 20);
        this.add(lebal4);
        String speed[] = {"10"};
        cb4 = new JComboBox(speed);
        cb4.setBounds(110, 200, 90, 20);


        JLabel lebal5 = new JLabel("Please select the power source:");
        lebal5.setBounds(60, 230, 250, 20);
        this.add(lebal5);
        manual = new JRadioButton("manual");
        manual.setBounds(110, 260, 70, 20);

        JLabel lebal6 = new JLabel("Please type the type military/civilian?");
        lebal6.setBounds(60, 290, 250, 20);
        this.add(lebal6);
        civilian = new JRadioButton("civilian");
        civilian.setBounds(110, 320, 70, 20);


        JLabel lebal7 = new JLabel("Please select an energy score:");
        lebal7.setBounds(70, 350, 250, 40);
        this.add(lebal7);
        String Score[] = {"A"};
        cb1 = new JComboBox(Score);
        cb1.setBounds(90, 380, 120, 20);

        JLabel lebal10 = new JLabel("Please add photo:");
        lebal10.setBounds(70, 420, 250, 40);
        this.add(lebal10);
        add_photo = new JButton();
        add_photo.setBounds(100, 450, 90, 50);
        add_photo.setText("add photo");
        add_photo.addActionListener(this);
        this.add(add_photo);


        add = new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15, 520, 120, 50);
        add.addActionListener(this);


        add_and_closs = new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155, 520, 120, 50);
        add_and_closs.addActionListener(this);


        this.add(move);
        this.add(distance);
        this.add(manual);
        this.add(civilian);
        this.add(add);
        this.add(add_and_closs);
        this.add(cb1);
        this.add(cb4);
        this.add(cb6);
        this.add(cb5);


    }

    /**
     * This method processes an ActionEvent, which is generated when the user interacts with the GUI.
     * <p>
     * The method reads data from various input fields in the GUI, creates a new vehicle object based on the input,
     * If the "add photo" button is pressed, the method opens a file chooser dialog and allows the user to select a photo file,
     * which is then copied to a designated folder.
     * If we click on adding a new vehicle then it will add the vehicle we have just entered to the array
     * and return us to fill in details about the new vehicle we would like to add
     * If we click on adding the vehicle and opening the agency, it will add the vehicle
     * we have just entered to the array of vehicles and open the agency window where there are pictures of all the vehicles in the agency
     *
     * @param e the event to be processed
     */


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("<html>Adding a<br />new vehicle</html>")) {
            String s1 = (String) cb5.getSelectedItem();
            String s2 = move.getText();
            String s3 = distance.getText();
            String s4 = (String) cb6.getSelectedItem();
            String s5 = (String) cb4.getSelectedItem();
            String s6 = civilian.getText();

            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);

            Game_Drone temp = new Game_Drone(f, s1, s, a, b, c, s6);
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

        } else if (e.getActionCommand().equals("<html>Adding and entering<br />a car dealership</html>")) {
            String s1 = (String) cb5.getSelectedItem();
            String s2 = move.getText();
            String s3 = distance.getText();
            String s4 = (String) cb6.getSelectedItem();
            String s5 = (String) cb4.getSelectedItem();
            String s6 = civilian.getText();

            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);

            Game_Drone temp = new Game_Drone(f, s1, s, a, b, c, s6);
            Car_Agency.add_Vehicle(temp);

            Agency_Frame frame = new Agency_Frame(Car_Agency.get_vehicle(), s);

            this.dispose();

        }

    }
}




