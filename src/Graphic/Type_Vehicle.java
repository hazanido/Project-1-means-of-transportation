package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Type_Vehicle extends JFrame implements ActionListener{
    private JButton Air;
    private JButton Land;
    private JButton Marine;

    public Type_Vehicle() {
        this.setVisible(true);
        this.setSize(500, 100);
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
            Maritime type_M = new Maritime();
            Marine.add(type_M);
        }
        else if (e.getActionCommand().equals("Land transport vehicle")) {
            Terrestrial type_M = new Terrestrial();
            Land.add(type_M);

        } else if (e.getActionCommand().equals("Air transport vehicles")) {
            Aerial type_M = new Aerial();
            Air.add(type_M);
        }

    }

}

