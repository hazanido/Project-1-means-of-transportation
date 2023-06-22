package Graphic.Vehicle_gui;

import Graphic.Agency_Frame;
import Graphic.Threads_class;
import Graphic.Vehicle_gui.Type_Vehicle;
import Graphic.main_window;
import Vehicle.Car_Agency;
import Vehicle.Jeep;

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
 * The `Jeep` class represents a GUI for adding new vehicle objects to an array.
 * It extends the `JFrame` class and implements the `ActionListener` interface.
 */
public class jeep extends JFrame implements ActionListener {
    private JTextField model, move, distance, passengers, speed, Fuel_consumption, lifetime;
    private JButton add, add_and_closs,add_photo;
    private JComboBox cb,cb1,cb3;
    private JCheckBox checkbox1;
    private File f;
    private BufferedImage b_Definitions_photo;
    private ImageIcon i_Definitions_photo;

    /**
     * Constructs a new Jeep object and initializes its GUI components.
     * The method also initializes all the text fields and labels that will be displayed on the frame,
     * sets their positions and sizes, and adds them to the frame.
     */
    public jeep() {
        // Set window properties
        this.setVisible(true);
        this.setSize(300, 830);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Jeep");

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
        model = new JTextField();
        model.setBounds(70, 60, 150, 20);
        model.setToolTipText("please enter model of car");
        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(70, 90, 150, 20);
        panel.add(lebal1);
        move = new JTextField();
        move.setBounds(70, 110, 150, 20);
        move.setToolTipText("please enter ability to move the vehicle");
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 140, 150, 20);
        panel.add(lebal2);
        distance = new JTextField();
        distance.setBounds(70, 160, 150, 20);
        distance.setToolTipText("please enter the distance the vehicle traveled during its lifetime");


        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 190, 150, 20);
        panel.add(lebal4);
        speed = new JTextField();
        speed.setBounds(70, 220, 150, 20);
        speed.setToolTipText("Please type the maximum speed of the vehicle");

        JLabel lebal5 = new JLabel("Fuel consumption:");
        lebal5.setBounds(70, 250, 150, 20);
        panel.add(lebal5);
        Fuel_consumption = new JTextField();
        Fuel_consumption.setBounds(70, 280, 150, 20);
        Fuel_consumption.setToolTipText("Please enter the average fuel consumption of the vehicle");

        JLabel lebal6 = new JLabel("lifetime:");
        lebal6.setBounds(70, 310, 150, 20);
        panel.add(lebal6);
        lifetime = new JTextField();
        lifetime.setBounds(70, 330, 150, 20);
        lifetime.setToolTipText("Please type the average lifetime of the engine");

        JLabel lebal13 = new JLabel("Maximum number of passengers:");
        lebal13.setBounds(70, 360, 250, 40);
        panel.add(lebal13);
        String passengers[] = {"5"};
        cb1 = new JComboBox(passengers);
        cb1.setBounds(70, 390, 120, 20);
        panel.add(cb1);


        JLabel lebal7 = new JLabel("Select a number of wheels:");
        lebal7.setBounds(70, 420, 250, 40);
        panel.add(lebal7);
        String wheels[] = {"4"};
        cb = new JComboBox(wheels);
        cb.setBounds(70, 450, 120, 20);
        panel.add(cb);

        JLabel lebal8 = new JLabel("Select the license type:");
        lebal8.setBounds(70, 480, 250, 40);
        panel.add(lebal8);
        String license[] = {"Mini"};
        JComboBox cb1 = new JComboBox(license);
        cb1.setBounds(75, 510, 120, 20);
        panel.add(cb1);

        JLabel lebal9 = new JLabel("The kind of way:");
        lebal9.setBounds(90, 540, 150, 20);
        panel.add(lebal9);
        checkbox1 = new JCheckBox("dirt");
        checkbox1.setBounds(110, 570, 60, 30);

        JLabel lebal20 = new JLabel("Select a color of car:");
        lebal20.setBounds(70, 610, 250, 40);
        panel.add(lebal20);

        String wheels1[] = {"green","blue","red"};
        cb3 = new JComboBox(wheels1);
        cb3.setBounds(70, 625, 120, 20);
        panel.add(cb3);

        JLabel lebal10 = new JLabel("Please add photo:");
        lebal10.setBounds(70, 650, 250, 40);
        panel.add(lebal10);
        add_photo = new JButton();
        add_photo.setBounds(100, 680, 90, 50);
        add_photo.setText("add photo");
        add_photo.addActionListener(this);
        panel.add(add_photo);

        add = new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15, 740, 120, 50);
        add.addActionListener(this);


        add_and_closs = new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155, 740, 120, 50);
        add_and_closs.addActionListener(this);


        panel.add(model);
        panel.add(move);
        panel.add(distance);
        panel.add(speed);
        panel.add(add);
        panel.add(add_and_closs);
        panel.add(Fuel_consumption);
        panel.add(lifetime);
        panel.add(checkbox1);


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
            String s4 = (String) cb1.getSelectedItem();
            String s5 = speed.getText();
            String s6 = checkbox1.getText();
            String s7 = (String) cb.getSelectedItem();
            String s9 = (String) cb3.getSelectedItem();


            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);
            int d = Integer.parseInt(s7);

            Jeep temp = new Jeep(f, s1, s, a, b, c, d, s6,s9);
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

        }
        else if(e.getActionCommand().equals("<html>Adding and entering<br />a car dealership</html>")){
            String s1 = model.getText();
            String s2 = move.getText();
            String s3 = distance.getText();
            String s4 = (String) cb1.getSelectedItem();
            String s5 = speed.getText();
            String s6 = checkbox1.getText();
            String s7 = (String) cb.getSelectedItem();
            String s9 = (String) cb3.getSelectedItem();


            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);
            int d = Integer.parseInt(s7);

            Jeep temp = new Jeep(f, s1, s, a, b, c, d, s6,s9);
            //Car_Agency.add_Vehicle(temp);
            Threads_class.get_Instance().addVehicle(this,temp);


            Agency_Frame frame=new Agency_Frame(Threads_class.get_Instance().get_Vehicles());

            this.dispose();

        }

    }
}






