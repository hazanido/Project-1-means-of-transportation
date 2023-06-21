package Graphic.Vehicle_gui;
import Graphic.Agency_Frame;
import Graphic.Threads_class;
import Graphic.Vehicle_gui.Type_Vehicle;
import Graphic.main_window;
import Vehicle.Car_Agency;
import Vehicle.Dawn_Rigoli;
import Vehicle.Vehicle;

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
 * The `dawn rigoli` class represents a GUI for adding new vehicle objects to an array.
 * It extends the `JFrame` class and implements the `ActionListener` interface.
 */

public class dawn_rigoli extends JFrame implements ActionListener {
    private JTextField move, distance;
    private JButton add, add_and_closs, add_photo;
    private String model[] = {"privileged"};
    private String passengers[] = {"1"};
    private String speed[] = {"50"};
    private String Score[] = {"C"};
    private JRadioButton military;
    private JComboBox cb5, cb6, cb4, cb1,cb3;
    private File f;
    private BufferedImage b_Definitions_photo;
    private ImageIcon i_Definitions_photo;

    /**
     * Constructs a new dawn rigoli object and initializes its GUI components.
     * The method also initializes all the text fields and labels that will be displayed on the frame,
     * sets their positions and sizes, and adds them to the frame.
     */

    public dawn_rigoli() {
        // Set window properties
        this.setVisible(true);
        this.setSize(300, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Dawn rigoli");

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

        cb5 = new JComboBox(model);
        cb5.setBounds(110, 40, 90, 20);
        panel.add(cb5);

        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(70, 70, 150, 20);
        panel.add(lebal1);

        move = new JTextField();
        move.setBounds(70, 90, 150, 20);
        move.setToolTipText("please enter ability to move the vehicle");
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 120, 150, 20);
        panel.add(lebal2);

        distance = new JTextField();
        distance.setBounds(70, 140, 150, 20);
        distance.setToolTipText("please enter the distance the vehicle traveled during its lifetime");
        JLabel lebal3 = new JLabel("Max passengers:");
        lebal3.setBounds(70, 170, 150, 20);
        panel.add(lebal3);

        cb6 = new JComboBox(passengers);
        cb6.setBounds(180, 170, 50, 20);
        panel.add(cb6);

        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 200, 150, 20);
        panel.add(lebal4);

        JLabel lebal8 = new JLabel("km");
        lebal8.setBounds(200, 200, 150, 20);
        panel.add(lebal8);

        cb4 = new JComboBox(speed);
        cb4.setBounds(110, 200, 90, 20);
        panel.add(cb4);

        //Please type the type military/civilia
        JLabel lebal5 = new JLabel("Please type the type military/civilian?");
        lebal5.setBounds(60, 230, 250, 20);
        panel.add(lebal5);

        military = new JRadioButton("military");
        military.setBounds(110, 250, 70, 20);
        JLabel lebal6 = new JLabel("Please select an energy score:");
        lebal6.setBounds(70, 270, 250, 40);
        panel.add(lebal6);

        cb1 = new JComboBox(Score);
        cb1.setBounds(90, 310, 120, 20);
        panel.add(cb1);

        JLabel lebal7 = new JLabel("Please select the power source:");
        lebal7.setBounds(70, 330, 250, 40);
        panel.add(lebal7);

        JRadioButton manual = new JRadioButton("manual");
        JRadioButton electric = new JRadioButton("electric");
        manual.setBounds(30, 370, 90, 20);
        electric.setBounds(160, 370, 90, 20);

        JLabel lebal14 = new JLabel("Select a color of car:");
        lebal14.setBounds(70, 380, 250, 40);
        panel.add(lebal14);

        String wheels1[] = {"green","blue","red"};
        cb3 = new JComboBox(wheels1);
        cb3.setBounds(70, 390, 120, 20);
        panel.add(cb3);

        panel.add(move);
        panel.add(distance);
        panel.add(military);
        panel.add(manual);
        panel.add(electric);

        //add photo
        JLabel lebal9 = new JLabel("Please add photo:");
        lebal9.setBounds(70, 400, 250, 40);
        panel.add(lebal9);
        //this.add(lebal9);
        add_photo = new JButton();
        add_photo.setBounds(100, 420, 90, 50);
        add_photo.setText("add photo");
        add_photo.addActionListener(this);
        panel.add(add_photo);


        //add button
        add = new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15, 480, 110, 50);
        add.addActionListener(this);
        panel.add(add);
        add_and_closs = new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155, 480, 120, 50);
        add_and_closs.addActionListener(this);
        panel.add(add_and_closs);

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
            String s6 = military.getText();
            String s8 = (String) cb1.getSelectedItem();
            String s9 = (String) cb3.getSelectedItem();

            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);

            Dawn_Rigoli temp1 = new Dawn_Rigoli(f, s1, s, a, b, c, s6,s9);
            //Car_Agency.add_Vehicle(temp1);
            System.out.println(temp1.toString());
            Car_Agency.print();
            Threads_class.get_Instance().addVehicle(this,temp1);

            Type_Vehicle temp = new Type_Vehicle();
            temp.setVisible(true);

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
            String s6 = military.getText();
            String s9 = (String) cb3.getSelectedItem();

            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);


            Dawn_Rigoli temp1 = new Dawn_Rigoli(f, s1, s, a, b, c, s6,s9);
            //Car_Agency.add_Vehicle(temp1);
            Threads_class.get_Instance().addVehicle(this,temp1);
            Agency_Frame frame = new Agency_Frame(Threads_class.get_Instance().get_Vehicles());
            frame.setVisible(true);
            this.dispose();
        }

    }
}




