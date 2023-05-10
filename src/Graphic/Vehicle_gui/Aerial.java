package Graphic.Vehicle_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aerial extends JFrame implements ActionListener {
JButton dawn_Rigoli;
JButton game_Drone;

    public Aerial(){
        this.setVisible(true);
        this.setSize(500, 100);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Air transport vehicles");
        this.setLayout(new FlowLayout());
        dawn_Rigoli = new JButton("Dawn_Rigoli");
        dawn_Rigoli.setBounds(20, 100, 200, 200);
        dawn_Rigoli.addActionListener(this);
        this.add(dawn_Rigoli);
        game_Drone = new JButton("Game_Drone");
        game_Drone.setBounds(300, 100, 200, 200);
        game_Drone.addActionListener(this);
        this.add(game_Drone);


    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Dawn_Rigoli")) {
            dawn_rigoli frame= new dawn_rigoli();
            this.dispose();
        }
        else if (e.getActionCommand().equals("Game_Drone")) {
            game_drone frame = new game_drone();
            this.dispose();

        }

    }
}
