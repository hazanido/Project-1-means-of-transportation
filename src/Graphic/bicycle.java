package Graphic;

import Vehicle.Bicycle;
import Vehicle.Car_Agency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bicycle extends JFrame implements ActionListener {
    private JTextField model,move,distance,passengers,speed;
    private JRadioButton manual;
    private JComboBox cb,cb1;
    private JButton add,add_and_closs;

    public bicycle(){
        this.setVisible(true);
        this.setSize(300, 570);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Bicycle");
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

        JLabel lebal6 = new JLabel("Select a number of wheels:");
        lebal6.setBounds(70, 280, 250, 40);
        this.add(lebal6);
        String wheels[]={"2"};
        cb=new JComboBox(wheels);
        cb.setBounds(70,310,80,20);
        this.add(cb);

        JLabel lebal7 = new JLabel("Select an energy score:");
        lebal7.setBounds(70, 330, 250, 40);
        this.add(lebal7);
        String Score[]={"A"};
        cb1=new JComboBox(Score);
        cb1.setBounds(70,360,80,20);
        this.add(cb1);

        JLabel lebal8 = new JLabel("Select the power source");
        lebal8.setBounds(70, 380, 250, 40);
        this.add(lebal8);
        manual = new JRadioButton("manual");
        manual.setBounds(100,420,90,20);


        add=new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15,470,120,50);
        add.addActionListener(this);


        add_and_closs=new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155,470,120,50);



        this.add(model);
        this.add(move);
        this.add(distance);
        this.add(passengers);
        this.add(speed);
        this.add(manual);
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
            String s6=manual.getText();
            String s7=(String) cb.getSelectedItem();
            String s8=(String) cb1.getSelectedItem();

            int s=Integer.parseInt(s2);
            double a=Double.parseDouble(s3);
            int b=Integer.parseInt(s4);
            double c=Double.parseDouble(s5);

            Bicycle temp1=new Bicycle(s1,s,a,b,c,2,null);
            Car_Agency.add_Vehicle(temp1);
            System.out.println(temp1.toString());
            Car_Agency.print();

            Type_Vehicle temp = new Type_Vehicle();
            this.dispose();


        }
    }

}
