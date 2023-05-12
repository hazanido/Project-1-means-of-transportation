package Graphic;

import Vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Test_drive extends JFrame implements ActionListener {
    private JButton Back;
    private JTextField move;
    private Vehicle vehicle;
    private int i;



    public Test_drive(int i, Vehicle[] vehicles) {
        this.vehicle = vehicles[i];
        this.setVisible(true);
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Test_drive");

        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(15, 20, 150, 20);
        this.add(lebal1);
        move = new JTextField();
        move.setBounds(15, 50, 150, 20);
        move.setToolTipText("Please enter the distance you traveled on a test drive");


        Back = new JButton();
        Back.setBounds(20, 100, 150, 30);
        Back.setText("Back to the agency");
        Back.addActionListener(this);
        this.add(Back);

        this.add(move);
        String s = move.getText();
        int s1 = Integer.parseInt(s);

        int temp = vehicles[i].get_move();
        vehicles[i].set_Move(temp + s1);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back to the agency")) {
            int distance = Integer.parseInt(move.getText());


            //Agency_Frame temp = new Agency_Frame();
            //temp.setVisible(true);
            this.dispose();
        }
    }

}



