package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Operations extends JFrame implements ActionListener {
    JButton test_drive,buying_car,Flag_change,Reset,Exit;


    public Operations(){
        this.setVisible(true);
        this.setSize(400, 320);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("test_drive or buying car");


        test_drive=new JButton("Test drive");
        buying_car=new JButton("Buying car");
        Flag_change=new JButton("Flag change");
        Reset=new JButton("Reset All");
        Exit=new JButton("Exit");


        test_drive.setBounds(30,40,150,60);
        test_drive.addActionListener(this);
        this.add(test_drive);

        buying_car.setBounds(200,40,150,60);
        buying_car.addActionListener(this);
        this.add(buying_car);

        Flag_change.setBounds(110,120,150,60);
        Flag_change.addActionListener(this);
        this.add(Flag_change);

        Reset.setBounds(15,240,100,30);
        Reset.addActionListener(this);
        this.add(Reset);

        Exit.setBounds(260,240,100,30);
        Exit.addActionListener(this);
        this.add(Exit);




    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Test drive")) {
            Test_drive frame=new Test_drive();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Buying car")){


        }

    }

}
