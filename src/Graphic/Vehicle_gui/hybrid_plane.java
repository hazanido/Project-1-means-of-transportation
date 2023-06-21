package Graphic.Vehicle_gui;

import Graphic.Agency_Frame;
import Graphic.Threads_class;
import Graphic.main_window;
import Vehicle.Amphibious_vehicle;
import Vehicle.Car_Agency;
import Vehicle.Hybrid_plane;

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

public class hybrid_plane extends JFrame implements ActionListener {
    private JTextField model,move,distance,passengers,speed,Fuel_consumption,lifetime,flag;
    private JButton add,add_and_closs,add_photo;
    private JRadioButton against, with,military;

    private JComboBox cb,cb3;
    private JCheckBox checkbox1;
    private File f;
    private BufferedImage b_Definitions_photo;
    private ImageIcon i_Definitions_photo;

    public hybrid_plane(){
        // Set window properties
        this.setVisible(true);
        this.setSize(300, 900);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("hybrid plane");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Definitions_photo = ImageIO.read(new File("src/Graphic/pictures/Definitions2.png"));
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

        JLabel lebal7 = new JLabel("Select a number of wheels:");
        lebal7.setBounds(70, 440, 250, 40);
        panel.add(lebal7);
        String wheels[] = {"1","2","3","4"};
        cb = new JComboBox(wheels);
        cb.setBounds(70, 470, 120, 20);
        panel.add(cb);

        JLabel lebal9 = new JLabel("The kind of way:");
        lebal9.setBounds(90, 500, 150, 20);
        panel.add(lebal9);
        checkbox1 = new JCheckBox("paved");
        checkbox1.setBounds(110, 520, 60, 30);

        JLabel lebal13 = new JLabel("Please type the type military/civilian?");
        lebal13.setBounds(60, 560, 250, 20);
        panel.add(lebal13);

        military = new JRadioButton("military");
        military.setBounds(110, 590, 70, 20);

        JLabel lebal12 = new JLabel("<html>Please Choose whether to<br /> sail with or against the wind ?:</html>");
        lebal12.setBounds(60, 630, 250, 40);
        panel.add(lebal12);
        against = new JRadioButton("against the wind");
        with = new JRadioButton("with the wind");
        against.setBounds(30, 680, 120, 20);
        with.setBounds(160, 680, 110, 20);

        JLabel lebal18 = new JLabel("Select a color of car:");
        lebal18.setBounds(70, 690, 250, 40);
        panel.add(lebal18);

        String wheels1[] = {"Natural","Blue","Red"};
        cb3 = new JComboBox(wheels1);
        cb3.setBounds(70, 700, 120, 20);
        panel.add(cb3);

        JLabel lebal10 = new JLabel("Please add photo:");
        lebal10.setBounds(70, 710, 250, 40);
        panel.add(lebal10);

        add_photo = new JButton();
        add_photo.setBounds(100, 740, 90, 50);
        add_photo.setText("add photo");
        add_photo.addActionListener(this);
        panel.add(add_photo);

        add=new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15,800,120,50);
        add.addActionListener(this);


        add_and_closs=new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(145,800,130,50);
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
        panel.add(military);
        panel.add(add_and_closs);


    }
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
            String s9 = (String) cb3.getSelectedItem();




            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);
            boolean fl = Boolean.parseBoolean(s6);
            boolean fl1 = Boolean.parseBoolean(s7);

            if (fl = true) {
                Hybrid_plane temp1 = new Hybrid_plane(f, s1, s, a, b, c,fl,s8,s9);
                Car_Agency.add_Vehicle(temp1);
                Threads_class.get_Instance().addVehicle(this,temp1);

            }
            else if (fl1 = true) {
                Hybrid_plane temp1 = new Hybrid_plane(f, s1, s, a, b, c,fl1,s8,s9);
                Car_Agency.add_Vehicle(temp1);
                Threads_class.get_Instance().addVehicle(this,temp1);

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

        } else if (e.getActionCommand().equals("<html>Adding and entering<br />a car dealership</html>")) {
            String s1 = model.getText();
            String s2 = move.getText();
            String s3 = distance.getText();
            String s4 = passengers.getText();
            String s5 = speed.getText();
            String s6 = with.getText();
            String s7 = against.getText();
            String s8 = flag.getText();
            String s9 = (String) cb3.getSelectedItem();



            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);
            boolean fl = Boolean.parseBoolean(s6);
            boolean fl1 = Boolean.parseBoolean(s7);

            if (fl = true) {
                Hybrid_plane temp1 = new Hybrid_plane(f, s1, s, a, b, c,fl,s8,s9);
                //Car_Agency.add_Vehicle(temp1);
                Threads_class.get_Instance().addVehicle(this,temp1);

            }
            else if (fl1 = true) {
                Hybrid_plane temp1 = new Hybrid_plane(f, s1, s, a, b, c,fl1,s8,s9);
                //Car_Agency.add_Vehicle(temp1);
                Threads_class.get_Instance().addVehicle(this,temp1);

            }



            Agency_Frame frame = new Agency_Frame(Threads_class.get_Instance().get_Vehicles());

            this.dispose();
        }
    }


}
