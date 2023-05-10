package Graphic.Vehicle_gui;

import Graphic.Vehicle_gui.Amphibious;
import Graphic.Vehicle_gui.bicycle;
import Graphic.Vehicle_gui.jeep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Terrestrial extends JFrame implements ActionListener {
    JButton Jeep;
    JButton Amphibious;
    JButton Bicycle;
    public Terrestrial(){
        this.setVisible(true);
        this.setSize(500, 100);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Land transport vehicle");
        this.setLayout(new FlowLayout());

        Jeep = new JButton("Jeep");
        Jeep.setBounds(20, 100, 200, 200);
        Jeep.addActionListener(this);
        this.add(Jeep);
        Amphibious = new JButton("Amphibious vehicle");
        Amphibious.setBounds(300, 100, 200, 200);
        Amphibious.addActionListener(this);
        this.add(Amphibious);
        Bicycle = new JButton("Bicycle");
        Bicycle.setBounds(600, 100, 200, 200);
        Bicycle.addActionListener(this);
        this.add(Bicycle);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Jeep")) {
            jeep frame= new jeep();
            this.dispose();
        }
        else if (e.getActionCommand().equals("Amphibious vehicle")) {
            Graphic.Vehicle_gui.Amphibious frame = new Amphibious();
            this.dispose();

        }
        else if (e.getActionCommand().equals("Bicycle")) {
            bicycle frame = new bicycle();
            this.dispose();

        }
    }

}
