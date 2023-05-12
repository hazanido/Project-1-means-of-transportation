package Graphic.Vehicle_gui;

import Graphic.Agency_Frame;
import Graphic.Vehicle_gui.Type_Vehicle;
import Vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Amphibious extends JFrame implements ActionListener {
    private JTextField model,move,distance,passengers,speed,Fuel_consumption,lifetime,flag;
    private JButton add,add_and_closs,add_photo;
    private JRadioButton against, with;

    private File f;
    public Amphibious(){
        this.setVisible(true);
        this.setSize(300, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Amphibious");
        JLabel lebal = new JLabel("model:");
        lebal.setBounds(70, 40, 150, 20);
        this.add(lebal);
        model=new JTextField();
        model.setBounds(70,60,150,20);
        model.setToolTipText("please enter model of car");
        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(70, 90, 150, 20);
        this.add(lebal1);
        move=new JTextField();
        move.setBounds(70,110,150,20);
        move.setToolTipText("please enter ability to move the vehicle");
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 140, 150, 20);
        this.add(lebal2);
        distance=new JTextField();
        distance.setBounds(70,160,150,20);
        distance.setToolTipText("please enter the distance the vehicle traveled during its lifetime");
        JLabel lebal3 = new JLabel("passengers:");
        lebal3.setBounds(70, 190, 150, 20);
        this.add(lebal3);
        passengers=new JTextField();
        passengers.setBounds(70,210,150,20);
        passengers.setToolTipText("please enter the number of passengers the vehicle contains");
        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 240, 150, 20);
        this.add(lebal4);
        speed=new JTextField();
        speed.setBounds(70,260,150,20);
        speed.setToolTipText("Please type the maximum speed of the vehicle");

        JLabel lebal5 = new JLabel("Fuel consumption:");
        lebal5.setBounds(70, 290, 150, 20);
        this.add(lebal5);
        Fuel_consumption=new JTextField();
        Fuel_consumption.setBounds(70,310,150,20);
        Fuel_consumption.setToolTipText("Please enter the average fuel consumption of the vehicle");

        JLabel lebal6 = new JLabel("lifetime:");
        lebal6.setBounds(70, 340, 150, 20);
        this.add(lebal6);
        lifetime=new JTextField();
        lifetime.setBounds(70,360,150,20);
        lifetime.setToolTipText("Please type the average lifetime of the engine");

        JLabel lebal11 = new JLabel("Flag:");
        lebal11.setBounds(70, 390, 150, 20);
        this.add(lebal11);
        flag = new JTextField();
        flag.setBounds(70, 410, 150, 20);
        flag.setToolTipText("Please type the name of the country to which the boat sailed");

        JLabel lebal12 = new JLabel("<html>Please Choose whether to<br /> sail with or against the wind ?:</html>");
        lebal12.setBounds(50, 450, 250, 40);
        this.add(lebal12);
        against = new JRadioButton("against the wind");
        with = new JRadioButton("with the wind");
        against.setBounds(30, 500, 120, 20);
        with.setBounds(160, 500, 110, 20);






        JLabel lebal9 = new JLabel("The kind of way:");
        lebal9.setBounds(90, 530, 150, 20);
        this.add(lebal9);
        JCheckBox checkbox1 = new JCheckBox("paved");
        checkbox1.setBounds(110,560, 60,30);








        JLabel lebal10 = new JLabel("Please add photo:");
        lebal10.setBounds(70, 590, 250, 40);
        this.add(lebal10);
        add_photo = new JButton();
        add_photo.setBounds(100, 620, 90, 50);
        add_photo.setText("add photo");
        add_photo.addActionListener(this);
        this.add(add_photo);



        add=new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15,700,120,50);
        add.addActionListener(this);


        add_and_closs=new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(145,700,130,50);
        add_and_closs.addActionListener(this);



        this.add(model);
        this.add(move);
        this.add(distance);
        this.add(passengers);
        this.add(speed);
        this.add(Fuel_consumption);
        this.add(lifetime);
        this.add(checkbox1);
        this.add(flag);
        this.add(against);
        this.add(with);
        this.add(add);
        this.add(add_and_closs);


    }
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



            Agency_Frame frame=new Agency_Frame(Car_Agency.get_vehicle(),s);

            this.dispose();
        }



    }
}
