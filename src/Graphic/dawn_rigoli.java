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
        model=new JTextField();
        model.setBounds(70,60,150,20);
        move=new JTextField();
        move.setBounds(70,110,150,20);
        distance=new JTextField();
        distance.setBounds(70,160,150,20);
        passengers=new JTextField();
        passengers.setBounds(70,210,150,20);
        speed=new JTextField();
        speed.setBounds(70,260,150,20);
        this.add(model);
        this.add(move);
        this.add(distance);
        this.add(passengers);
        this.add(speed);

    }


    public void actionPerformed(ActionEvent e) {
//yert
    }
}
