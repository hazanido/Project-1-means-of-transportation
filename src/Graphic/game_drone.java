package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class game_drone extends JFrame implements ActionListener {
    private JTextField move,distance;
    private JButton add,add_and_closs;
    public game_drone(){
        this.setVisible(true);
        this.setSize(300, 560);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Game drone");
        JLabel lebal = new JLabel("model:");
        lebal.setBounds(70, 40, 150, 20);
        this.add(lebal);
        String model[]={"Toy"};
        JComboBox cb5=new JComboBox(model);
        cb5.setBounds(110,40,90,20);
        this.add(cb5);
        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(70, 70, 150, 20);
        this.add(lebal1);
        move=new JTextField();
        move.setBounds(70,90,150,20);
        move.setToolTipText("please enter ability to move the vehicle");
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 120, 150, 20);
        this.add(lebal2);
        distance=new JTextField();
        distance.setBounds(70,140,150,20);
        distance.setToolTipText("please enter the distance the vehicle traveled during its lifetime");
        JLabel lebal3 = new JLabel("Max passengers:");
        lebal3.setBounds(70, 170, 150, 20);
        this.add(lebal3);
        String passengers[]={"0"};
        JComboBox cb6=new JComboBox(passengers);
        cb6.setBounds(180,170,50,20);
        this.add(cb6);
        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 200, 150, 20);
        this.add(lebal4);
        String speed[]={"10km"};
        JComboBox cb4=new JComboBox(speed);
        cb4.setBounds(110,200,90,20);
        this.add(cb4);

        JLabel lebal5 = new JLabel("Please select the power source:");
        lebal5.setBounds(60, 230, 250, 20);
        this.add(lebal5);
        JRadioButton manual = new JRadioButton("manual");
        manual.setBounds(110,260,70,20);

        JLabel lebal6 = new JLabel("Please type the type military/civilian?");
        lebal6.setBounds(60, 290, 250, 20);
        this.add(lebal6);
        JRadioButton civilian = new JRadioButton("civilian");
        civilian.setBounds(110,320,70,20);


        JLabel lebal7 = new JLabel("Please select an energy score:");
        lebal7.setBounds(70, 350, 250, 40);
        this.add(lebal7);
        String Score[]={"A"};
        JComboBox cb1=new JComboBox(Score);
        cb1.setBounds(90,380,120,20);
        this.add(cb1);

        add=new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15,420,120,50);
        add.addActionListener(this);


        add_and_closs=new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155,420,120,50);




        ;
        this.add(move);
        this.add(distance);
        this.add(manual);
        this.add(civilian);
        this.add(add);
        this.add(add_and_closs);

    }


    public void actionPerformed(ActionEvent e) {}

}
