package Graphic.Vehicle_gui;

import Graphic.Vehicle_gui.Type_Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Amphibious extends JFrame implements ActionListener {
    private JTextField model,move,distance,passengers,speed,Fuel_consumption,lifetime;
    private JButton add,add_and_closs;
    public Amphibious(){
        this.setVisible(true);
        this.setSize(300, 560);
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

        JLabel lebal9 = new JLabel("The kind of way:");
        lebal9.setBounds(90, 390, 150, 20);
        this.add(lebal9);
        JCheckBox checkbox1 = new JCheckBox("paved");
        checkbox1.setBounds(110,420, 60,30);

        add=new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15,460,120,50);
        add.addActionListener(this);


        add_and_closs=new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(145,460,130,50);



        this.add(model);
        this.add(move);
        this.add(distance);
        this.add(passengers);
        this.add(speed);
        this.add(Fuel_consumption);
        this.add(lifetime);
        this.add(checkbox1);
        this.add(add);
        this.add(add_and_closs);


    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("<html>Adding a<br />new vehicle</html>")) {

            //Amphibious temp1 = new (m, move, d, p, s, t);
            //Car_Agency.add_Vehicle(temp1);

            Type_Vehicle temp = new Type_Vehicle();
            this.dispose();
        }

    }
}
