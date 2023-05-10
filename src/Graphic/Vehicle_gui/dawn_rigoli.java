package Graphic.Vehicle_gui;
import Graphic.Vehicle_gui.Type_Vehicle;
import Vehicle.Car_Agency;
import Vehicle.Dawn_Rigoli;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class dawn_rigoli extends JFrame implements ActionListener {
    private JTextField move, distance;
    private JButton add, add_and_closs, add_photo;
    private String model[] = {"privileged"};
    private String passengers[] = {"1"};
    private String speed[] = {"50"};
    private String Score[] = {"C"};
    private JRadioButton military;
    private JComboBox cb5, cb6, cb4, cb1;
    private File f;

    public dawn_rigoli() {
        this.setVisible(true);
        this.setSize(300, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Dawn rigoli");
        //model
        JLabel lebal = new JLabel("model:");
        lebal.setBounds(70, 40, 150, 20);
        this.add(lebal);
        cb5 = new JComboBox(model);
        cb5.setBounds(110, 40, 90, 20);
        this.add(cb5);
        //Move
        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(70, 70, 150, 20);
        this.add(lebal1);
        move = new JTextField();
        move.setBounds(70, 90, 150, 20);
        move.setToolTipText("please enter ability to move the vehicle");
        //distance
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 120, 150, 20);
        this.add(lebal2);
        distance = new JTextField();
        distance.setBounds(70, 140, 150, 20);
        distance.setToolTipText("please enter the distance the vehicle traveled during its lifetime");
        //Max passengers
        JLabel lebal3 = new JLabel("Max passengers:");
        lebal3.setBounds(70, 170, 150, 20);
        this.add(lebal3);
        cb6 = new JComboBox(passengers);
        cb6.setBounds(180, 170, 50, 20);
        this.add(cb6);
        //speed
        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 200, 150, 20);
        this.add(lebal4);
        JLabel lebal8 = new JLabel("km");
        lebal8.setBounds(200, 200, 150, 20);
        this.add(lebal8);
        cb4 = new JComboBox(speed);
        cb4.setBounds(110, 200, 90, 20);
        this.add(cb4);
        //Please type the type military/civilia
        JLabel lebal5 = new JLabel("Please type the type military/civilian?");
        lebal5.setBounds(60, 230, 250, 20);
        this.add(lebal5);
        military = new JRadioButton("military");
        military.setBounds(110, 250, 70, 20);
        //energy score
        JLabel lebal6 = new JLabel("Please select an energy score:");
        lebal6.setBounds(70, 270, 250, 40);
        this.add(lebal6);
        cb1 = new JComboBox(Score);
        cb1.setBounds(90, 310, 120, 20);
        this.add(cb1);
        //power source
        JLabel lebal7 = new JLabel("Please select the power source:");
        lebal7.setBounds(70, 330, 250, 40);
        this.add(lebal7);
        JRadioButton manual = new JRadioButton("manual");
        JRadioButton electric = new JRadioButton("electric");
        manual.setBounds(30, 370, 90, 20);
        electric.setBounds(160, 370, 90, 20);


        this.add(move);
        this.add(distance);
        this.add(military);
        this.add(manual);
        this.add(electric);
        //add photo
        JLabel lebal9 = new JLabel("Please add photo:");
        lebal9.setBounds(70, 390, 250, 40);
        this.add(lebal9);
        add_photo = new JButton();
        add_photo.setBounds(100, 420, 90, 50);
        add_photo.setText("add photo");
        add_photo.addActionListener(this);
        this.add(add_photo);
        //add button
        add = new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15, 480, 110, 50);
        add.addActionListener(this);
        this.add(add);
        add_and_closs = new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155, 480, 120, 50);
        this.add(add_and_closs);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("<html>Adding a<br />new vehicle</html>")) {
            String s1 = (String) cb5.getSelectedItem();
            String s2 = move.getText();
            String s3 = distance.getText();
            String s4 = (String) cb6.getSelectedItem();
            String s5 = (String) cb4.getSelectedItem();
            String s6 = military.getText();
            String s8 = (String) cb1.getSelectedItem();

            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);

            Dawn_Rigoli temp1 = new Dawn_Rigoli(f,s1, s, a, b, c, s6);
            Car_Agency.add_Vehicle(temp1);
            System.out.println(temp1.toString());
            Car_Agency.print();

            Type_Vehicle temp = new Type_Vehicle();
            this.dispose();
        } else if (e.getActionCommand().equals("<html>Adding and entering<br />a car dealership</html>")) {
            String s1 = (String) cb5.getSelectedItem();
            String s2 = move.getText();
            String s3 = distance.getText();
            String s4 = (String) cb6.getSelectedItem();
            String s5 = (String) cb4.getSelectedItem();
            String s6 = military.getText();

            int s = Integer.parseInt(s2);
            double a = Double.parseDouble(s3);
            int b = Integer.parseInt(s4);
            double c = Double.parseDouble(s5);

            Dawn_Rigoli temp1 = new Dawn_Rigoli(f,s1, s, a, b, c, s6);
            Car_Agency.add_Vehicle(temp1);
            System.out.println(temp1.toString());
            Car_Agency.print();

            Type_Vehicle temp = new Type_Vehicle();
            this.dispose();
        }
            else if(e.getActionCommand().equals("add photo")){
                Path to;

                JFileChooser photo=new JFileChooser();
                int i = photo.showOpenDialog(null);
                f=photo.getSelectedFile();

                to = Paths.get("src/Graphic/pictures/" + f.getName());
                try {
                    Files.copy(f.toPath(),to.toFile().toPath());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }




