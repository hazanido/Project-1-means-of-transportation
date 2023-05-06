package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dawn_rigoli extends JFrame implements ActionListener {
    private JTextField model,move,distance,passengers,speed;
    public dawn_rigoli (){
        this.setVisible(true);
        this.setSize(300, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Type Vehicle");
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
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 140, 150, 20);
        this.add(lebal2);
        distance=new JTextField();
        distance.setBounds(70,160,150,20);
        JLabel lebal3 = new JLabel("passengers:");
        lebal3.setBounds(70, 190, 150, 20);
        this.add(lebal3);
        passengers=new JTextField();
        passengers.setBounds(70,210,150,20);
        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 240, 150, 20);
        this.add(lebal4);
        speed=new JTextField();
        speed.setBounds(70,260,150,20);
        this.add(model);
        this.add(move);
        this.add(distance);
        this.add(passengers);
        this.add(speed);

    }


    public void actionPerformed(ActionEvent e) {


    }
}
