package Graphic.Vehicle_gui;

import Graphic.Vehicle_gui.Amphibious;
import Graphic.Vehicle_gui.Cruz;
import Graphic.Vehicle_gui.frigate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Maritime extends JFrame implements ActionListener {
    JButton frigate;
    JButton Cruz;
    JButton Amphibious;

    public Maritime(){
        this.setVisible(true);
        this.setSize(500, 100);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Marine transport vehicle");
        this.setLayout(new FlowLayout());

        frigate = new JButton("Frigate");
        frigate.setBounds(20, 100, 200, 200);
        frigate.addActionListener(this);
        this.add(frigate);
        Cruz = new JButton("Cruise ship");
        Cruz.setBounds(300, 100, 200, 200);
        Cruz.addActionListener(this);
        this.add(Cruz);
        Amphibious = new JButton("Amphibious vehicle");
        Amphibious.setBounds(600, 100, 200, 200);
        Amphibious.addActionListener(this);
        this.add(Amphibious);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Frigate")) {
            Graphic.Vehicle_gui.frigate frame= new frigate();
            this.dispose();
        }
        else if (e.getActionCommand().equals("Cruise ship")) {
            Graphic.Vehicle_gui.Cruz frame = new Cruz();
            this.dispose();

        }
        else if (e.getActionCommand().equals("Amphibious vehicle")) {
            Graphic.Vehicle_gui.Amphibious frame = new Amphibious();
            this.dispose();

        }
    }
}
