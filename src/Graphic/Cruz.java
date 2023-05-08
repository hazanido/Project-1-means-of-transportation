package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vehicle.*;

public class Cruz extends JFrame implements ActionListener {
    private JTextField model,move,distance,passengers,speed,Fuel_consumption,lifetime,flag;
    private JButton add,add_and_closs;
    private JRadioButton with;
    public Cruz(){
        this.setVisible(true);
        this.setSize(300, 630);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Cruz");
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

        JLabel lebal9 = new JLabel("Flag:");
        lebal9.setBounds(70, 380, 150, 20);
        this.add(lebal9);
        flag=new JTextField();
        flag.setBounds(70,400,150,20);
        flag.setToolTipText("Please type the name of the country to which the boat sailed");

        JLabel lebal7 = new JLabel("<html>Please Choose whether to<br /> sail with or against the wind ?:</html>");
        lebal7.setBounds(70, 420, 250, 40);
        this.add(lebal7);
        with = new JRadioButton("with the wind");
        with.setBounds(75,450,110,20);

        JLabel lebal8 = new JLabel("Select the license type:");
        lebal8.setBounds(70, 480, 250, 40);
        this.add(lebal8);
        String license[]={"Unlimited"};
        JComboBox cb1=new JComboBox(license);
        cb1.setBounds(75,510,120,20);
        this.add(cb1);

        add=new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15,540,120,50);
        add.addActionListener(this);


        add_and_closs=new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155,540,120,50);

        this.add(model);
        this.add(move);
        this.add(distance);
        this.add(passengers);
        this.add(speed);
        this.add(Fuel_consumption);
        this.add(lifetime);
        this.add(with);
        this.add(flag);
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
            String s6=with.getText();
            String s8=flag.getText();

            int s=Integer.parseInt(s2);
            double a=Double.parseDouble(s3);
            int b=Integer.parseInt(s4);
            double c=Double.parseDouble(s5);
            boolean f=Boolean.parseBoolean(s8);


            Cruise_ship temp=new Cruise_ship(s1,s,a,b,c,f,s8);
            Car_Agency.add_Vehicle(temp);
            Type_Vehicle temp1=new Type_Vehicle();
            this.dispose();

        }


    }



}
