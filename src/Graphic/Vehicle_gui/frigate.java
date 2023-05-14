package Graphic.Vehicle_gui;

import Graphic.Agency_Frame;
import Graphic.Vehicle_gui.Type_Vehicle;
import Vehicle.Car_Agency;
import Vehicle.Frigate;

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
 * The `frigate` class represents a GUI for adding new vehicle objects to an array.
 * It extends the `JFrame` class and implements the `ActionListener` interface.
 */
public class frigate extends JFrame implements ActionListener {
    private JTextField model, move, distance, passengers, speed, flag;
    private JButton add, add_and_closs, add_photo;
    private JComboBox cb1, cb3, cb;
    private JRadioButton against, with;
    private File f;

    /**
     * Constructs a new frigate object and initializes its GUI components.
     * The method also initializes all the text fields and labels that will be displayed on the frame,
     * sets their positions and sizes, and adds them to the frame.
     */

    public frigate() {
        // Set window properties
        this.setVisible(true);
        this.setSize(300, 820);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Frigate");

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

        JLabel lebal5 = new JLabel("Flag:");
        lebal5.setBounds(70, 285, 150, 20);
        this.add(lebal5);
        flag = new JTextField();
        flag.setBounds(70, 310, 150, 20);
        flag.setToolTipText("Please type the name of the country to which the boat sailed");

        JLabel lebal9 = new JLabel("<html>Please type the country<br /> the boat belongs to:<html>");
        lebal9.setBounds(70, 340, 400, 40);
        this.add(lebal9);
        String Israel[] = {"Israel"};
        cb = new JComboBox(Israel);
        cb.setBounds(70, 380, 120, 20);
        this.add(cb);

        JLabel lebal6 = new JLabel("<html>Please select the<br /> average fuel consumption:<html>");
        lebal6.setBounds(70, 420, 400, 40);
        this.add(lebal6);
        String fuel[] = {"500"};
        cb3 = new JComboBox(fuel);
        cb3.setBounds(70, 460, 120, 20);
        this.add(cb3);

        JLabel lebal7 = new JLabel("<html>Please, select the average<br /> lifetime of the engine:<html>");
        lebal7.setBounds(70, 490, 400, 40);
        this.add(lebal7);
        String license[] = {"4"};
        cb1 = new JComboBox(license);
        cb1.setBounds(70, 530, 120, 20);
        this.add(cb1);


        JLabel lebal8 = new JLabel("<html>Please Choose whether to<br /> sail with or against the wind ?:</html>");
        lebal8.setBounds(50, 550, 250, 40);
        this.add(lebal8);
        against = new JRadioButton("against the wind");
        with = new JRadioButton("with the wind");
        against.setBounds(30, 600, 120, 20);
        with.setBounds(160, 600, 110, 20);

        JLabel lebal10 = new JLabel("Please add photo:");
        lebal10.setBounds(70, 630, 250, 40);
        this.add(lebal10);
        add_photo = new JButton();
        add_photo.setBounds(100, 660, 90, 50);
        add_photo.setText("add photo");
        add_photo.addActionListener(this);
        this.add(add_photo);


        add = new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15, 720, 120, 50);
        add.addActionListener(this);


        add_and_closs = new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155, 720, 120, 50);
        add_and_closs.addActionListener(this);


        this.add(model);
        this.add(move);
        this.add(distance);
        this.add(passengers);
        this.add(speed);
        this.add(flag);
        this.add(against);
        this.add(with);
        this.add(add);
        this.add(add_and_closs);

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
                Frigate temp1 = new Frigate(f, s1, s, a, b, c, fl, s8);
                Car_Agency.add_Vehicle(temp1);
            } else if (fl1 = true) {
                Frigate temp1 = new Frigate(f, s1, s, a, b, c, fl1, s8);
                Car_Agency.add_Vehicle(temp1);
            }

            Type_Vehicle temp = new Type_Vehicle();
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

        else if (e.getActionCommand().equals("<html>Adding and entering<br />a car dealership</html>")) {
            String s1 = model.getText();
            String s2 = move.getText();
            String s3 = distance.getText();
            String s4 = passengers.getText();
            String s5 = speed.getText();
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
                Frigate temp1 = new Frigate(f, s1, s, a, b, c, fl, s8);
                Car_Agency.add_Vehicle(temp1);
            } else if (fl1 = true) {
                Frigate temp1 = new Frigate(f, s1, s, a, b, c, fl1, s8);
                Car_Agency.add_Vehicle(temp1);
            }
            Agency_Frame frame=new Agency_Frame(Car_Agency.get_vehicle(),s);

            this.dispose();

        }

    }
}











