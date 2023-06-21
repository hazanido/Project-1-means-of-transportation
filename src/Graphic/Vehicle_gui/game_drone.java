package Graphic.Vehicle_gui;

import Graphic.Agency_Frame;
import Graphic.Threads_class;
import Graphic.Vehicle_gui.Type_Vehicle;
import Graphic.main_window;
import Vehicle.Car_Agency;
import Vehicle.Game_Drone;

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
 * The `game drone` class represents a GUI for adding new vehicle objects to an array.
 * It extends the `JFrame` class and implements the `ActionListener` interface.
 */
public class game_drone extends JFrame implements ActionListener {
    private JTextField move, distance;
    private JButton add, add_and_closs, add_photo;
    private JComboBox cb5, cb6, cb4, cb1,cb3;
    private JRadioButton manual, civilian;
    private File f;
    private BufferedImage b_Definitions_photo;
    private ImageIcon i_Definitions_photo;

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
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Game drone");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Definitions_photo = ImageIO.read(new File("src/Graphic/pictures/Definitions.png"));
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
        //this.add(lebal);
        String model[] = {"Toy"};
        cb5 = new JComboBox(model);
        cb5.setBounds(110, 40, 90, 20);
        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(70, 70, 150, 20);
        panel.add(lebal1);
        //this.add(lebal1);
        move = new JTextField();
        move.setBounds(70, 90, 150, 20);
        move.setToolTipText("please enter ability to move the vehicle");
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 120, 150, 20);
        panel.add(lebal2);
        //this.add(lebal2);
        distance = new JTextField();
        distance.setBounds(70, 140, 150, 20);
        distance.setToolTipText("please enter the distance the vehicle traveled during its lifetime");
        JLabel lebal3 = new JLabel("Max passengers:");
        lebal3.setBounds(70, 170, 150, 20);
        panel.add(lebal3);
        //this.add(lebal3);
        String passengers[] = {"0"};
        cb6 = new JComboBox(passengers);
        cb6.setBounds(180, 170, 50, 20);

        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 200, 150, 20);
        panel.add(lebal4);
        //this.add(lebal4);
        String speed[] = {"10"};
        cb4 = new JComboBox(speed);
        cb4.setBounds(110, 200, 90, 20);


        JLabel lebal5 = new JLabel("Please select the power source:");
        lebal5.setBounds(60, 230, 250, 20);
        panel.add(lebal5);
        //this.add(lebal5);
        manual = new JRadioButton("manual");
        manual.setBounds(110, 260, 70, 20);

        JLabel lebal6 = new JLabel("Please type the type military/civilian?");
        lebal6.setBounds(60, 290, 250, 20);
        panel.add(lebal6);
        //this.add(lebal6);
        civilian = new JRadioButton("civilian");
        civilian.setBounds(110, 320, 70, 20);


        JLabel lebal7 = new JLabel("Please select an energy score:");
        lebal7.setBounds(70, 350, 250, 40);
        panel.add(lebal7);
        //this.add(lebal7);
        String Score[] = {"A"};
        cb1 = new JComboBox(Score);
        cb1.setBounds(90, 380, 120, 20);

        JLabel lebal18 = new JLabel("Select a color of car:");
        lebal18.setBounds(70, 400, 250, 40);
        panel.add(lebal18);

        String wheels1[] = {"Natural","Blue","Red"};
        cb3 = new JComboBox(wheels1);
        cb3.setBounds(70, 410, 120, 20);
        panel.add(cb3);

        JLabel lebal10 = new JLabel("Please add photo:");
        lebal10.setBounds(70, 420, 250, 40);
        panel.add(lebal10);
        //this.add(lebal10);
        add_photo = new JButton();
        add_photo.setBounds(100, 450, 90, 50);
        add_photo.setText("add photo");
        add_photo.addActionListener(this);
        panel.add(add_photo);
        //this.add(add_photo);


        add = new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15, 520, 120, 50);
        add.addActionListener(this);
        panel.add(add);


        add_and_closs = new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155, 520, 120, 50);
        add_and_closs.addActionListener(this);
        panel.add(add_and_closs);


        panel.add(move);
        panel.add(distance);
        panel.add(manual);
        panel.add(civilian);
        panel.add(cb1);
        panel.add(cb4);
        panel.add(cb5);
        panel.add(cb6);
        panel.add(manual);




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
            String s9 = (String) cb3.getSelectedItem();

            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);

            Game_Drone temp = new Game_Drone(f, s1, s, a, b, c, s6,s9);
            //Car_Agency.add_Vehicle(temp);
            Threads_class.get_Instance().addVehicle(this,temp);

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
            String s9 = (String) cb3.getSelectedItem();

            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);

            Game_Drone temp = new Game_Drone(f, s1, s, a, b, c, s6,s9);
            //Car_Agency.add_Vehicle(temp);
            Threads_class.get_Instance().addVehicle(this,temp);


            Agency_Frame frame = new Agency_Frame(Threads_class.get_Instance().get_Vehicles());

            this.dispose();

        }

    }
}




