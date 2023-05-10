package Graphic.Vehicle_gui;

import Graphic.Vehicle_gui.Aerial;
import Graphic.Vehicle_gui.Maritime;
import Graphic.Vehicle_gui.Terrestrial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Type_Vehicle extends JFrame implements ActionListener{
    private JButton Air;
    private JButton Land;
    private JButton Marine;
    private Graphic.Vehicle_gui.Terrestrial Terrestrial;
    private Graphic.Vehicle_gui.Maritime Maritime;
    private Graphic.Vehicle_gui.Aerial Aerial;
    public Type_Vehicle() {
        this.setVisible(true);
        this.setSize(500, 120);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Type Vehicle");
        this.setLayout(new FlowLayout());

        Air = new JButton("Air transport vehicles");
        Air.addActionListener(this);
        this.add(Air);
        Land = new JButton("Land transport vehicle");
        Land.addActionListener(this);
        this.add(Land);
        Marine = new JButton("Marine transport vehicle");
        Marine.addActionListener(this);
        this.add(Marine);


    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Marine transport vehicle")) {
            Maritime = new Maritime();
            this.dispose();
        }
        else if (e.getActionCommand().equals("Land transport vehicle")) {
            Terrestrial = new Terrestrial();
            this.dispose();

        } else if (e.getActionCommand().equals("Air transport vehicles")) {
            Aerial  = new Aerial();
            this.dispose();
        }

    }

}

