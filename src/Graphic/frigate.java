package Graphic;

import Vehicle.Bicycle;
import Vehicle.Car_Agency;
import Vehicle.Frigate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frigate extends JFrame implements ActionListener {
    private JTextField model,move,distance,passengers,speed,flag;
    private JButton add,add_and_closs;
    public frigate(){
        this.setVisible(true);
        this.setSize(300, 740);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Frigate");
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

        JLabel lebal5 = new JLabel("Flag:");
        lebal5.setBounds(70, 285, 150, 20);
        this.add(lebal5);
        flag=new JTextField();
        flag.setBounds(70,310,150,20);
        flag.setToolTipText("Please type the name of the country to which the boat sailed");

        JLabel lebal9 = new JLabel("<html>Please type the country<br /> the boat belongs to:<html>");
        lebal9.setBounds(70, 340, 400, 40);
        this.add(lebal9);
        String Israel[]={"Israel"};
        JComboBox cb=new JComboBox(Israel);
        cb.setBounds(70,380,120,20);
        this.add(cb);

        JLabel lebal6 = new JLabel("<html>Please select the<br /> average fuel consumption:<html>");
        lebal6.setBounds(70, 420, 400, 40);
        this.add(lebal6);
        String fuel[]={"500"};
        JComboBox cb3=new JComboBox(fuel);
        cb3.setBounds(70,460,120,20);
        this.add(cb3);

        JLabel lebal7 = new JLabel("<html>Please, select the average<br /> lifetime of the engine:<html>");
        lebal7.setBounds(70, 490, 400, 40);
        this.add(lebal7);
        String license[]={"4"};
        JComboBox cb1=new JComboBox(license);
        cb1.setBounds(70,530,120,20);
        this.add(cb1);



        JLabel lebal8 = new JLabel("<html>Please Choose whether to<br /> sail with or against the wind ?:</html>");
        lebal8.setBounds(50, 550, 250, 40);
        this.add(lebal8);
        JRadioButton against = new JRadioButton("against the wind");
        JRadioButton with = new JRadioButton("with the wind");
        against.setBounds(30,600,120,20);
        with.setBounds(160,600,110,20);



        add=new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15,630,120,50);
        add.addActionListener(this);


        add_and_closs=new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155,630,120,50);


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
    public void actionPerformed(ActionEvent e) {
        //public void actionPerformed(ActionEvent e) {
            //if (e.getActionCommand().equals("<html>Adding a<br />new vehicle</html>")) {
                //Frigate temp1=new Frigate(model,move,distance,passengers,speed,2,null);
                //Car_Agency.add_Vehicle(temp1);

                //Type_Vehicle temp = new Type_Vehicle();
                //this.dispose();


            }
        }





